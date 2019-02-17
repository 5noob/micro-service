package com.me.springaplication.typefilter;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author OuyangJie
 * @Date 2019/2/17 17:14
 * @Description: 存在于spring Bean池中的TypeExcludeFilter，结合下面的注解，用来验证TypeExcludeFilter的作用
 *     @ComponentScans({
 *         @ComponentScan(basePackages = "com.me.scantest", excludeFilters = {
 *                 @ComponentScan.Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class)
 *         })
 *     })
 */
@Component
public class MyTypeExcludeFilter extends TypeExcludeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        System.out.println("=== 调用MyTypeExcludeFilter的match方法 ===");
        return false;
    }
}
