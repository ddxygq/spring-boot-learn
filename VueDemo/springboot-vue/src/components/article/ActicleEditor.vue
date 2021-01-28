<template>
  <div>
    <el-row>
      <el-input
        v-model="article.title"
        style="margin: 10px 0px;font-size: 18px;"
        placeholder="请输入标题">
      </el-input>
    </el-row>

    <el-row style="height: calc(100vh - 140px);">
      <mavon-editor
        v-model="article.articleContentMd"
        style="height: 100%;"
        ref=md
        @save="saveArticle"
        fontSize="16px">
      </mavon-editor>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'article',
    components: {},
    data() {
      return {
        article: {}
      }
    },
    mounted () {
      if (this.$route.params.article){
        this.article = this.$route.params.article
      }
    },
    methods: {
      saveArticle(value, render) {
        // value 是 md，render 是 html
        this.$confirm('保存', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'info'
        }).then(() => {
          this.$axios
            .post('/article/addArticle', {
              title: this.article.title,
              contentMd: value,
              contentHtml: render,
              date: new Date()
            }).then(res => {
            if (res && res.data.code == 200) {
              this.$message({
                type: 'success',
                message: '已保存成功'
              })
            }
          })
        }).catch(() => {
          this.$message({
            type: 'warning',
            message: '已取消保存'
          })
        })
      }
    }
  }
</script>


