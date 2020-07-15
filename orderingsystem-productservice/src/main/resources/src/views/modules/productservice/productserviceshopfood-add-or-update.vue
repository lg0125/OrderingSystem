<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="foodName">
      <el-input v-model="dataForm.foodName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="foodPrice">
      <el-input v-model="dataForm.foodPrice" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="foodNum">
      <el-input v-model="dataForm.foodNum" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="typeId">
      <el-input v-model="dataForm.typeId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="flavor">
      <el-input v-model="dataForm.flavor" placeholder=""></el-input>
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
    <el-form-item label="" prop="shopId">
      <el-input v-model="dataForm.shopId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="foodId">
      <el-input v-model="dataForm.foodId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="version">
      <el-input v-model="dataForm.version" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="imageUrl">
      <el-input v-model="dataForm.imageUrl" placeholder=""></el-input>
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
          foodName: '',
          foodPrice: '',
          foodNum: '',
          typeId: '',
          flavor: '',
          deleted: '',
          gmtCreate: '',
          gmtModified: '',
          shopId: '',
          foodId: '',
          version: '',
          imageUrl: ''
        },
        dataRule: {
          foodName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          foodPrice: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          foodNum: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          typeId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          flavor: [
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
          ],
          shopId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          foodId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          version: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          imageUrl: [
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
              url: this.$http.adornUrl(`/productservice/productserviceshopfood/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.foodName = data.productServiceShopFood.foodName
                this.dataForm.foodPrice = data.productServiceShopFood.foodPrice
                this.dataForm.foodNum = data.productServiceShopFood.foodNum
                this.dataForm.typeId = data.productServiceShopFood.typeId
                this.dataForm.flavor = data.productServiceShopFood.flavor
                this.dataForm.deleted = data.productServiceShopFood.deleted
                this.dataForm.gmtCreate = data.productServiceShopFood.gmtCreate
                this.dataForm.gmtModified = data.productServiceShopFood.gmtModified
                this.dataForm.shopId = data.productServiceShopFood.shopId
                this.dataForm.foodId = data.productServiceShopFood.foodId
                this.dataForm.version = data.productServiceShopFood.version
                this.dataForm.imageUrl = data.productServiceShopFood.imageUrl
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
              url: this.$http.adornUrl(`/productservice/productserviceshopfood/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'foodName': this.dataForm.foodName,
                'foodPrice': this.dataForm.foodPrice,
                'foodNum': this.dataForm.foodNum,
                'typeId': this.dataForm.typeId,
                'flavor': this.dataForm.flavor,
                'deleted': this.dataForm.deleted,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified,
                'shopId': this.dataForm.shopId,
                'foodId': this.dataForm.foodId,
                'version': this.dataForm.version,
                'imageUrl': this.dataForm.imageUrl
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
