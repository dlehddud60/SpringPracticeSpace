package org.zerock.myapp.gson;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.zerock.myapp.domain.Foo;

import com.google.gson.Gson;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class GsonTests {
	
	
	// ************************************************************************** //
	// JAVA 객체 ============> JSON 문자열로 변환 : 직렬화(Serialization) 
	// ************************************************************************** //
	@Test
	public void testSerialize() {
		log.trace("testSerialize() invoke.");
		
		Foo foo = new Foo();
		foo.setId(1000);
		foo.setName("Nayoung");
		
		log.info("foo: {}", foo);
		

//		------------------ 
		
//		Bar bar = new Bar();
//		bar.setId(1000);
//		bar.setName("Nayoung");
//		
//		log.info("foo: {}", bar);
		
//		------------------ 여기까지 객체 생성 구간
		
//		Map<String,Integer> obj =new HashMap<>();
//		obj.put("KEY1", 1);
//		obj.put("KEY2", 2);
//		obj.put("KEY3", 3);
////		------------------ 
		
//		Bar bar = new Bar();
//		bar.setId(333);
//		bar.setName("nayoung");
//		Foo obj = new Foo();
//		obj.setId(777);
//		obj.setName("jooho");
//		obj.setBar(bar);
//		
//		log.info("foo : {}",obj);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(foo);
//		String json = gson.toJson(bar);
		
//		String json = gson.toJson(obj);
		
		log.info("json: {}", json);
		
	} // testSerialize
	//=================================
	//JSON문자열 ===> JAVA 객체로 변환 역직렬화
	//=============================
	
	
	@Test
	public void testDeserialize() {
		log.trace("testDeserialize1() invoked");
		
//		String json = "{\"id\": 1000 , \"name\" : \"Jooho\"}"//1st method
		String json ="{'id':1000,'name': 'Jooho'}";		//2nd method
		
//		------
		//제가 소개하는 4개의 JSOn 는 바이트 코드 조작기능이 있음 
		//때문에 Private 필드라도 바로 값을 넣어버린다.
		Gson gson = new Gson();
//		Foo obj =gson.<Foo>fromJson(json, Foo.class);
//		Bar obj =gson.<Bar>fromJson(json, Bar.class);
//		MyClass obj =gson.<MyClass>fromJson(json, MyClass.class);
//		Map<String, Object> map= new HashMap<>();  
		
//		MyClass obj =gson.<MyClass>fromJson(json, MyClass.class);
//		Map<String, Object> obj =gson.<Map<String, Object>>fromJson(json, MyClass.class);
//		assertNotNull(obj);
//		log.info("\t +obj: {}",obj);
		
		
	}
	@Test
	public void testDeserialize2() {
		log.trace("testDeserialize2() invoked");
		
//		Date now = new Date();
		Calendar calendar =Calendar.getInstance();
		Date now = calendar.getTime();
		log.info("\t +1. now: {}", now);
//		
//		Gson gson = new Gson();
//		String json =json.toJson(now);
//		log.info("");
//		
//		LocalDateTime now =LocalDateTime.now(); //Joda Date & Time
//		LocalTime now= LocalTime.now();  //Joda Time xx
		
		log.info("\t1. now: {}", now);
		
		
//		String json ="[1.0,2,.3]";
		//배열로 역변환시에는 미리 크기에 맞는 배열을 생성.
//		double[]  obj=new double[3];
//		Set<Double> obj =new HashSet<>(3);
//		Gson gson = new Gson();
//		obj =gson.<Set<Double>>fromJson(json,obj.getClass());
//		Objects.requireNonNull(obj);
//		log.info("obj: {}, type: {}", obj,obj.getClass().getName());
	}
	
	

} // end class 
