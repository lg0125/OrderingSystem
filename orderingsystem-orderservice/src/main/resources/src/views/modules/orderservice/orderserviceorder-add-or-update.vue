<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gmtCreate">
      <el-input v-model="dataForm.gmtCreate" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gmtModified">
      <el-input v-model="dataForm.gmtModified" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="deleted">
      <el-input v-model="dataForm.deleted" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="payState">
      <el-input v-model="dataForm.payState" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="finishState">
      <el-input v-model="dataForm.finishState" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shopId">
      <el-input v-model="dataForm.shopId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="orderAccount">
      <el-input v-model="dataForm.orderAccount" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          orderId: 0,
          userId: '',
          gmtCreate: '',
          gmtModified: '',
          deleted: '',
          payState: '',
          finishState: '',
          shopId: '',
          orderAccount: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gmtCreate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gmtModified: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          deleted: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          payState: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          finishState: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shopId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          orderAccount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.orderId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.orderId) {
            this.$http({
              url: this.$http.adornUrl(`/orderservice/orderserviceorder/info/${this.dataForm.orderId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.orderServiceOrder.userId
                this.dataForm.gmtCreate = data.orderServiceOrder.gmtCreate
                this.dataForm.gmtModified = data.orderServiceOrder.gmtModified
                this.dataForm.deleted = data.orderServiceOrder.deleted
                this.dataForm.payState = data.orderServiceOrder.payState
                this.dataForm.finishState = data.orderServiceOrder.finishState
                this.dataForm.shopId = data.orderServiceOrder.shopId
                this.dataForm.orderAccount = data.orderServiceOrder.orderAccount
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/orderservice/orderserviceorder/${!this.dataForm.orderId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'orderId': this.dataForm.orderId || undefined,
                'userId': this.dataForm.userId,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified,
                'deleted': this.dataForm.deleted,
                'payState': this.dataForm.payState,
                'finishState': this.dataForm.finishState,
                'shopId': this.dataForm.shopId,
                'orderAccount': this.dataForm.orderAccount
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
