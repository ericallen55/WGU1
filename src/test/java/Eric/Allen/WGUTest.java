package Eric.Allen;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class WGUTest {
  @Test
  public void Test(){
	List<String> strings = Arrays.asList(
			"BBBbBBBB", //B2B
			"Automotive",   //A6e
			"1defabc1 cb!a %%%def1123", //1d4c1 c0b!a %%%d1f1123
			"a hot character",  //a h1t c6r
			"at",   //a0t
			"x",    //x
			"tipu-is-smart",    //t2u-i0s-s3t
			"1234567890",   //1234567890
			"a98779079745092740", //a98779079745092740
			"98779079745092740a" //98779079745092740a
	);
	WGU wgu = new WGU();

    List<String> output = wgu.WGU(strings);
    assertThat(output, notNullValue());
    assertThat(output.get(0), is("B2B"));
    assertThat(output.get(1), is("A6e"));
    assertThat(output.get(2), is("1d4c1 c0b!a %%%d1f1123"));
    assertThat(output.get(3), is("a h1t c6r"));
    assertThat(output.get(4), is("a0t"));
    assertThat(output.get(5), is("x"));
    assertThat(output.get(6), is("t2u-i0s-s3t"));
    assertThat(output.get(7), is("1234567890"));
    assertThat(output.get(8), is("a98779079745092740"));
    assertThat(output.get(9), is("98779079745092740a"));
  }
}
