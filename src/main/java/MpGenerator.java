import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {

    /**
     * 输出路径
      */

    final static String outPath = "C:\\Users\\Huohuo\\Desktop\\新建文件夹";
    // 数据库地址
    final static String url =
        "jdbc:mysql://120.201.137.165:6021/landsubsidy?characterEncoding=UTF-8&useUnicode=true&useSSL=false";
    // 用户名
    final static String username = "admin_gx01";
    // 密码
    final static String password = "Admin_gx01";
    // 作者
    final static String author = "huozhenbin";
    // 父级包名
    final static String parentPackage = "org.jeecg.modules.basisorg";
    // 表名数组
//    final static String[] includeTables = {"auth_user_role","farmer_base_info","auth_user_info","auth_role"};
    final static String[] includeTables = {"risk_farmer_base_info"};

    final static String[] excludeTables = {};
    // 表名前缀数组
    final static String[] tablePrefix = {};

    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        autoGenerator.setDataSource(dsc);
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outPath);
        gc.setFileOverride(true);
        // ActiveRecord特性
        gc.setActiveRecord(false);
        // XML二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(false);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor(author);// 作者
        gc.setSwagger2(true);// Swagger2
        // 日期类型
        gc.setDateType(DateType.ONLY_DATE);
        gc.setIdType(IdType.ID_WORKER_STR);

        // 自定义文件命名，注意%s 会自动填充表实体属性
        gc.setControllerName("%sController");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        autoGenerator.setGlobalConfig(gc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(tablePrefix);// 此处可以修改您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        if (includeTables.length > 0) {
            strategy.setInclude(includeTables);// 需要生成的表
        } else {
            if (excludeTables.length > 0) {
                strategy.setExclude(excludeTables);// 需要排除的表
            }
        }
        strategy.setRestControllerStyle(true);
        strategy.setEntityLombokModel(true);
        strategy.setSuperServiceClass(null);
        strategy.setSuperServiceImplClass(null);
        strategy.setSuperMapperClass(null);

        autoGenerator.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(parentPackage);
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        pc.setXml("mapper.xml");
        autoGenerator.setPackageInfo(pc);
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
        autoGenerator.setCfg(injectionConfig);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        // 执行生成
        autoGenerator.execute();
    }

}