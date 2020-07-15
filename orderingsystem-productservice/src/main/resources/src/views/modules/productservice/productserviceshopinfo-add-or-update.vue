<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="shopId">
      <el-input v-model="dataForm.shopId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="addressId">
      <el-input v-model="dataForm.addressId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="phone">
      <el-input v-model="dataForm.phone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="supportId">
      <el-input v-model="dataForm.supportId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sellNum">
      <el-input v-model="dataForm.sellNum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="minPrice">
      <el-input v-model="dataForm.minPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="deliveryPrice">
      <el-input v-model="dataForm.deliveryPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="distance">
      <el-input v-model="dataForm.distance" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="activityId">
      <el-input v-model="dataForm.activityId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="imageUrl">
      <el-input v-model="dataForm.imageUrl" placeholder=""></el-input>
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
          shopId: '',
          addressId: '',
          phone: '',
          supportId: '',
          sellNum: '',
          minPrice: '',
          deliveryPrice: '',
          distance: '',
          activityId: '',
          imageUrl: '',
          version: '',
          deleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          shopId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          addressId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          phone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          supportId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sellNum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          minPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          deliveryPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          distance: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          activityId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          imageUrl: [
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
              url: this.$http.adornUrl(`/productservice/productserviceshopinfo/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.shopId = data.productServiceShopInfo.shopId
                this.dataForm.addressId = data.productServiceShopInfo.addressId
                this.dataForm.phone = data.productServiceShopInfo.phone
                this.dataForm.supportId = data.productServiceShopInfo.supportId
                this.dataForm.sellNum = data.productServiceShopInfo.sellNum
                this.dataForm.minPrice = data.productServiceShopInfo.minPrice
                this.dataForm.deliveryPrice = data.productServiceShopInfo.deliveryPrice
                this.dataForm.distance = data.productServiceShopInfo.distance
                this.dataForm.activityId = data.productServiceShopInfo.activityId
                this.dataForm.imageUrl = data.productServiceShopInfo.imageUrl
                this.dataForm.version = data.productServiceShopInfo.version
                this.dataForm.deleted = data.productServiceShopInfo.deleted
                this.dataForm.gmtCreate = data.productServiceShopInfo.gmtCreate
                this.dataForm.gmtModified = data.productServiceShopInfo.gmtModified
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
              url: this.$http.adornUrl(`/productservice/productserviceshopinfo/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'shopId': this.dataForm.shopId,
                'addressId': this.dataForm.addressId,
                'phone': this.dataForm.phone,
                'supportId': this.dataForm.supportId,
                'sellNum': this.dataForm.sellNum,
                'minPrice': this.dataForm.minPrice,
                'deliveryPrice': this.dataForm.deliveryPrice,
                'distance': this.dataForm.distance,
                'activityId': this.dataForm.activityId,
                'imageUrl': this.dataForm.imageUrl,
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
