package com.WebsiteDaiHocDienTu.config;

import com.sun.jdi.LongType;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.spi.TypeConfiguration;

import java.io.Serializable;
import java.util.Properties;


public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator {
    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "";
    private String numberFormat;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return valuePrefix + String.format(numberFormat, super.generate(session,object));
    }

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
        super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), parameters, serviceRegistry);

        valuePrefix = ConfigurationHelper.getString(VALUE_PREFIX_PARAMETER,
                parameters, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(NUMBER_FORMAT_PARAMETER,
                parameters, NUMBER_FORMAT_DEFAULT);
    }
}
