<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="orderId">
      <el-input v-model="dataForm.orderId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="foodId">
      <el-input v-model="dataForm.foodId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shopId">
      <el-input v-model="dataForm.shopId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="foodAccount">
      <el-input v-model="dataForm.foodAccount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="version">
      <el-input v-model="dataForm.version" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="deleted">
      <el-input v-model="dataForm.deleted" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gmtCreate">
      <el-input v-model="dataForm.gmtCreate" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gmtModified">
      <el-input v-model="dataForm.gmtModified" placeholder=""></el-input>
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
          id: 0,
          orderId: '',
          foodId: '',
          shopId: '',
          foodAccount: '',
          version: '',
          deleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          orderId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          foodId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shopId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          foodAccount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          deleted: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gmtCreate: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gmtModified: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/orderservice/orderserviceorderitem/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.orderId = data.orderServiceOrderItem.orderId
                this.dataForm.foodId = data.orderServiceOrderItem.foodId
                this.dataForm.shopId = data.orderServiceOrderItem.shopId
                this.dataForm.foodAccount = data.orderServiceOrderItem.foodAccount
                this.dataForm.version = data.orderServiceOrderItem.version
                this.dataForm.deleted = data.orderServiceOrderItem.deleted
                this.dataForm.gmtCreate = data.orderServiceOrderItem.gmtCreate
                this.dataForm.gmtModified = data.orderServiceOrderItem.gmtModified
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
              url: this.$http.adornUrl(`/orderservice/orderserviceorderitem/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'orderId': this.dataForm.orderId,
                'foodId': this.dataForm.foodId,
                'shopId': this.dataForm.shopId,
                'foodAccount': this.dataForm.foodAccount,
                'version': this.dataForm.version,
                'deleted': this.dataForm.deleted,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified
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
