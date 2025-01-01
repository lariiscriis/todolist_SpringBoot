package br.com.larissacristina.todolist.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.BeanUtils;

//classe utilitária para obter os nomes das propriedades nulas de um objeto, ajuda para atualizar um objeto parcialmente
public class Utils {

    // copia as propriedades não nulas de um objeto para outro
    public static void copyNonNullProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, getNullPropertyNames(source));
    }

    // retorna os nomes das propriedades nulas de um objeto
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);

        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();

        for (PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());

            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }

        // retorna um array de strings com os nomes das propriedades nulas
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
