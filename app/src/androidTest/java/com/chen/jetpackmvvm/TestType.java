package com.chen.jetpackmvvm;

import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Map;


public class TestType <K extends Comparable & Serializable, V> {
    K key;
    V value;

    Map<String, String> map;

    List<String>[] lists;

    private List<? extends Number> a; // 上限
    private List<? super String> b; //下限

    public static void main(String[] args) throws Exception {
//        /**
//         * TypeVariable
//         */
//        // 获取字段的类型
//        Field fk = TestType.class.getDeclaredField("key");
//        Field fv = TestType.class.getDeclaredField("value");
//
//        //getGenericType()  获取属性的类型
//        TypeVariable keyType = (TypeVariable)fk.getGenericType();
//        TypeVariable valueType = (TypeVariable)fv.getGenericType();
//
//        // getName 方法     返回泛型变量的名称
//        System.out.println(keyType.getName());       // K
//        System.out.println(valueType.getName());     // V
//
//        // getGenericDeclaration 方法  返回声明泛型的类
//        System.out.println(keyType.getGenericDeclaration());        // class com.test.TestType
//        System.out.println(valueType.getGenericDeclaration());      // class com.test.TestType
//
//
//        // getBounds 方法  返回泛型声明的边界
//        System.out.println("K 的上界:"); // 有两个
//        for (Type type : keyType.getBounds()) {         // interface java.lang.Comparable
//            System.out.println(type);                   // interface java.io.Serializable
//        }
//        System.out.println("V 的上界:");
//        // 没明确声明上界的, 默认上界是 Object
//        for (Type type : valueType.getBounds()) { // class java.lang.Object
//            System.out.println(type);
//        }
//
//        /**
//         *ParameterizedType
//         */
//        Field f = TestType.class.getDeclaredField("map");
//
//        //getGenericType()  获取属性的类型
//        System.out.println(f.getGenericType()); // java.util.Map<java.lang.String, java.lang.String>
//
//        ParameterizedType pType = (ParameterizedType) f.getGenericType();
//
//        // getRawType  获取声明泛型的类  也就是 map
//        System.out.println(pType.getRawType()); // interface java.util.Map
//
//        // getActualTypeArguments  获取泛型的实际类型
//        for (Type type : pType.getActualTypeArguments()) {
//            System.out.println(type); // 打印两遍: class java.lang.String
//        }
//        /**
//         * GenericArrayType
//         */
//        Field f = TestType.class.getDeclaredField("lists");
//
//        //获取属性的类型
//        GenericArrayType genericType = (GenericArrayType) f.getGenericType();
//
//        // getGenericComponentType()  返回泛型数组中元素的Type类型
//        System.out.println(genericType.getGenericComponentType());  //java.util.List<java.lang.String>
//
//        /**
//         * WildcardType
//         */
//        Field fa = TestType.class.getDeclaredField("a");
//        Field fb = TestType.class.getDeclaredField("b");
//
//        //获取泛型类型
//        ParameterizedType pa = (ParameterizedType) fa.getGenericType();
//        ParameterizedType pb = (ParameterizedType) fb.getGenericType();
//
//        System.out.println(fa.getGenericType());        // java.util.List<? extends java.lang.Number>
//        System.out.println(fb.getGenericType());        // java.util.List<? super java.lang.String>
//
//        //从泛型获取通配符类型
//        WildcardType wa = (WildcardType) pa.getActualTypeArguments()[0];
//        WildcardType wb = (WildcardType) pb.getActualTypeArguments()[0];
//
//        System.out.println(wa);         // ? extends java.lang.Number
//        System.out.println(wb);         // ? super java.lang.String
//
//        /**
//         * getUpperBounds &  getLowerBounds
//         * 获取泛型通配符的上下限
//         */
//        System.out.println(wa.getUpperBounds()[0]);     // class java.lang.Number
//        System.out.println(wb.getLowerBounds()[0]);     // class java.lang.String
    }

}
