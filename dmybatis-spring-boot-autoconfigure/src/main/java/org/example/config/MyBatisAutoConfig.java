package org.example.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.List;

@AutoConfiguration
public class MyBatisAutoConfig {

    //SqlSessionFactoryBean
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        return sqlSessionFactoryBean;
    }

    //MapperScannerConfigure
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(BeanFactory beanFactory){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        //Scanning Package
        List<String> packages = AutoConfigurationPackages.get(beanFactory);
        String p = packages.get(0);
        mapperScannerConfigurer.setBasePackage(p);
        //Scanning Annotation
        mapperScannerConfigurer.setAnnotationClass(Mapper.class);

        return mapperScannerConfigurer;
    }

}
