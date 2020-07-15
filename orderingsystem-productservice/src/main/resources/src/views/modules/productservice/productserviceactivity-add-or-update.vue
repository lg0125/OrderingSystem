<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="activityId">
      <el-input v-model="dataForm.activityId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="activityName">
      <el-input v-model="dataForm.activityName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="activityDescription">
      <el-input v-model="dataForm.activityDescription" placeholder=""></el-input>
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
    <el-form-item label="" prop="iconName">
      <el-input v-model="dataForm.iconName" placeholder=""></el-input>
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
          activityId: '',
          activityName: '',
          activityDescription: '',
          version: '',
          deleted: '',
          gmtCreate: '',
          gmtModified: '',
          iconName: ''
        },
        dataRule: {
          activityId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          activityName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          activityDescription: [
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
          ],
          iconName: [
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
              url: this.$http.adornUrl(`/productservice/productserviceactivity/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.activityId = data.productServiceActivity.activityId
                this.dataForm.activityName = data.productServiceActivity.activityName
                this.dataForm.activityDescription = data.productServiceActivity.activityDescription
                this.dataForm.version = data.productServiceActivity.version
                this.dataForm.deleted = data.productServiceActivity.deleted
                this.dataForm.gmtCreate = data.productServiceActivity.gmtCreate
                this.dataForm.gmtModified = data.productServiceActivity.gmtModified
                this.dataForm.iconName = data.productServiceActivity.iconName
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
              url: this.$http.adornUrl(`/productservice/productserviceactivity/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'activityId': this.dataForm.activityId,
                'activityName': this.dataForm.activityName,
                'activityDescription': this.dataForm.activityDescription,
                'version': this.dataForm.version,
                'deleted': this.dataForm.deleted,
                'gmtCreate': this.dataForm.gmtCreate,
                'gmtModified': this.dataForm.gmtModified,
                'iconName': this.dataForm.iconName
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
