package util;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
public class ExportDB {
	public static void main(String[] args) {
		//读取hibernate.cfg.xml文件
		Configuration cfg = new Configuration().configure();
		//将类导成数据库的表
		SchemaExport export = new SchemaExport(cfg);
		//两个参数而参见hibernate的API，设为true即可
		export.create(true, true);
	}
}
