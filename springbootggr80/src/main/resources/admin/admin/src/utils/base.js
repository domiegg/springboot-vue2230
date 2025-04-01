const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootggr80/",
            name: "springbootggr80",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootggr80/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "智慧学生校舍系统"
        } 
    }
}
export default base
