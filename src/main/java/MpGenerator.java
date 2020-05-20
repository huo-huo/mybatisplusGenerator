import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {

    // 输出路径
    final static String outPath = "C:\\Users\\Huo\\Desktop\\新建文件夹";
    // 数据库地址
    final static String url =
        "jdbc:mysql://218.60.3.126:23306/auth_huinong?characterEncoding=UTF-8&useUnicode=true&useSSL=false";
    // 用户名
    final static String username = "root";
    // 密码
    final static String password = "Unicom@2019";
    // 作者
    final static String author = "huozhenbin";
    // 父级包名
    final static String parentPackage = "org.huinong.wechatauth.modules.wechatauth";
    // 表名数组
    final static String[] includeTables = {};
    final static String[] excludeTables = {""};
    // 表名前缀数组
    final static String[] tablePrefix = {};

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPath);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML二级缓存
        gc.setBaseResultMap(false);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(author);// 作者

        // 自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(tablePrefix);// 此处可以修改您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        if (includeTables.length > 0) {
            strategy.setInclude(includeTables);// 需要生成的表
        }
        if (excludeTables.length > 0) {
            strategy.setExclude(excludeTables);// 需要排除的表
        }
        strategy.setEntityLombokModel(true);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mapper.xml");
        mpg.setPackageInfo(pc);
        // 自定义属性注入 没有这个不报错 但是生成失败
        InjectionConfig injectionConfig = new InjectionConfig() {
            // 自定义属性注入:abc
            // 在.ftl(或者是.vm)模板中，通过${cfg.abc}获取属性
            @Override
            public void initMap() {
                // Map<String, Object> map = new HashMap<>();
                // map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                // this.setMap(map);
            }
        };
        // 配置自定义属性注入
        mpg.setCfg(injectionConfig);

        // 执行生成
        mpg.execute();
    }

}