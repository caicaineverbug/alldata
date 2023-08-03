/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { defineComponent, PropType, renderSlot } from 'vue'
import { useI18n } from 'vue-i18n'
import { NModal, NCard, NButton, NSpace } from 'naive-ui'

const props = {
  show: {
    type: Boolean as PropType<boolean>,
    default: false
  },
  title: {
    type: String as PropType<string>,
    required: true
  },
  cancelText: {
    type: String as PropType<string>
  },
  cancelShow: {
    type: Boolean as PropType<boolean>,
    default: true
  },
  confirmText: {
    type: String as PropType<string>
  },
  confirmClassName: {
    type: String as PropType<string>,
    default: ''
  },
  cancelClassName: {
    type: String as PropType<string>,
    default: ''
  },
  confirmDisabled: {
    type: Boolean as PropType<boolean>,
    default: false
  },
  confirmLoading: {
    type: Boolean as PropType<boolean>,
    default: false
  }
}

const Modal = defineComponent({
  name: 'Modal',
  props,
  emits: ['cancel', 'confirm'],
  setup(props, ctx) {
    const { t } = useI18n()

    const onCancel = () => {
      ctx.emit('cancel')
    }

    const onConfirm = () => {
      ctx.emit('confirm')
    }

    return { t, onCancel, onConfirm }
  },
  render() {
    const { $slots, t, onCancel, onConfirm, confirmDisabled, confirmLoading } =
      this

    return (
      <NModal
        v-model={[this.show, 'show']}
        mask-closable={false}
        style={{ width: '600px' }}
      >
        <NCard title={this.title} contentStyle={{ overflowY: 'auto' }}>
          {{
            default: () => renderSlot($slots, 'default'),
            footer: () => (
              <NSpace justify='end'>
                {this.cancelShow && (
                  <NButton quaternary size='small' onClick={onCancel}>
                    {this.cancelText || t('modal.cancel')}
                  </NButton>
                )}
                <NButton
                  size='small'
                  onClick={onConfirm}
                  disabled={confirmDisabled}
                  loading={confirmLoading}
                  type='primary'
                >
                  {this.confirmText || t('modal.confirm')}
                </NButton>
              </NSpace>
            )
          }}
        </NCard>
      </NModal>
    )
  }
})

export default Modal
