<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="supportId">
      <el-input v-model="dataForm.supportId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="supportName">
      <el-input v-model="dataForm.supportName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="iconName">
      <el-input v-model="dataForm.iconName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="description">
      <el-input v-model="dataForm.description" placeholder=""></el-input>
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
          supportId: '',
          supportName: '',
          iconName: '',
          description: '',
          version: '',
          deleted: '',
          gmtCreate: '',
          gmtModified: ''
        },
        dataRule: {
          supportId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          supportName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          iconName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
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
              url: this.$http.adornUrl(`/productservice/productservicesupport/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.supportId = data.productServiceSupport.supportId
                this.dataForm.supportName = data.productServiceSupport.supportName
                this.dataForm.iconName = data.productServiceSupport.iconName
                this.dataForm.description = data.productServiceSupport.description
                this.dataForm.version = data.productServiceSupport.version
                this.dataForm.deleted = data.productServiceSupport.deleted
                this.dataForm.gmtCreate = data.productServiceSupport.gmtCreate
                this.dataForm.gmtModified = data.productServiceSupport.gmtModified
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
              url: this.$http.adornUrl(`/productservice/productservicesupport/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'supportId': this.dataForm.supportId,
                'supportName': this.dataForm.supportName,
                'iconName': this.dataForm.iconName,
                'description': this.dataForm.description,
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
