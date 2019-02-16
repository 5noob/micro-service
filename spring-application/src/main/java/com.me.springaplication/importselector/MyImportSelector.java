package com.me.springaplication.importselector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author OuyangJie
 * @Date 2019/2/14 8:53
 * @Description:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.me.springaplication.domain.person"};
    }
}
