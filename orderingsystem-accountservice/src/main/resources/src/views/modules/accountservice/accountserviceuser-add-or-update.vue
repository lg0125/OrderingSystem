<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="userPassword">
      <el-input v-model="dataForm.userPassword" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="nickName">
      <el-input v-model="dataForm.nickName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="gender">
      <el-input v-model="dataForm.gender" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="telephone">
      <el-input v-model="dataForm.telephone" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="registerDate">
      <el-input v-model="dataForm.registerDate" placeholder=""></el-input>
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
    <el-form-item label="" prop="addressId">
      <el-input v-model="dataForm.addressId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="userName">
      <el-input v-model="dataForm.userName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="cardId">
      <el-input v-model="dataForm.cardId" placeholder=""></el-input>
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
          userId: '',
          userPassword: '',
          nickName: '',
          gender: '',
          telephone: '',
          registerDate: '',
          gmtCreate: '',
          gmtModified: '',
          deleted: '',
          addressId: '',
          userName: '',
          cardId: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          userPassword: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          nickName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          telephone: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          registerDate: [
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
          addressId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          cardId: [
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
              url: this.$http.adornUrl(`/accountservice/accountserviceuser/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.accountServiceUser.userId
                this.dataForm.userPassword = data.accountServiceUser.userPassword
                this.dataForm.nickName = data.accountServiceUser.nickName
                this.dataForm.gender = data.accountServiceUser.gender
                this.dataForm.telephone = data.accountServiceUser.telephone
                this.dataForm.registerDate = data.accountServiceUser.registerDate
                this.dataForm.gmtCreate = data.accountServiceUser.gmtCreate
                this.dataForm.gmtModified = data.accountServiceUser.gmtModified
                this.dataForm.deleted = data.accountServiceUser.deleted
                this.dataForm.addressId = data.accountServiceUser.addressId
                this.dataForm.userName = data.accountServiceUser.userName
                this.dataForm.cardId = data.accountServiceUser.cardId
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
              url: this.$http.adornUrl(`/accountservice/accountserviceuser/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'userPassword': this.dataForm.userPassword,
                'nickName': this.dataForm.nickName,
                'gender': this.dataForm.gender,
                'telephone': this.dataForm.telephone,
                'registerDate': this.dataForm.registerDate,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified,
                'deleted': this.dataForm.deleted,
                'addressId': this.dataForm.addressId,
                'userName': this.dataForm.userName,
                'cardId': this.dataForm.cardId
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
