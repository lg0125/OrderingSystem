<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="address">
      <el-input v-model="dataForm.address" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="city">
      <el-input v-model="dataForm.city" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="latitude">
      <el-input v-model="dataForm.latitude" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="longitude">
      <el-input v-model="dataForm.longitude" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="addressId">
      <el-input v-model="dataForm.addressId" placeholder=""></el-input>
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
          address: '',
          city: '',
          latitude: '',
          longitude: '',
          name: '',
          addressId: ''
        },
        dataRule: {
          address: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          city: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          latitude: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          longitude: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          addressId: [
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
              url: this.$http.adornUrl(`/productservice/productserviceshopaddress/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.address = data.productServiceShopAddress.address
                this.dataForm.city = data.productServiceShopAddress.city
                this.dataForm.latitude = data.productServiceShopAddress.latitude
                this.dataForm.longitude = data.productServiceShopAddress.longitude
                this.dataForm.name = data.productServiceShopAddress.name
                this.dataForm.addressId = data.productServiceShopAddress.addressId
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
              url: this.$http.adornUrl(`/productservice/productserviceshopaddress/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'address': this.dataForm.address,
                'city': this.dataForm.city,
                'latitude': this.dataForm.latitude,
                'longitude': this.dataForm.longitude,
                'name': this.dataForm.name,
                'addressId': this.dataForm.addressId
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
