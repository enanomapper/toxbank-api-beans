package net.toxbank.client.io.rdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import net.toxbank.client.resource.IToxBankResource;

import org.junit.Assert;
import org.junit.Test;

import com.hp.hpl.jena.rdf.model.Model;

public abstract class AbstractIOClassTest<T extends IToxBankResource> {

	private static int counter = 0;

	public IOClass<T> getIOClass() {
		Assert.fail("This method must be overwritten");
		return null;
	}

	@Test
	public void testFromJena_AcceptNullModel() {
		IOClass<T> ioClass = getIOClass();
		List<T> results = ioClass.fromJena(null);
		Assert.assertNotNull(results);
		Assert.assertEquals(0, results.size());
	}

	@Test
	public void testToJena_AcceptNullModel() {
		IOClass<T> ioClass = getIOClass();
		Model results = ioClass.toJena(null, (T[])null);
		Assert.assertNotNull(results);
	}
	
	protected File getOutputFile(Object object, String ext) {
	  counter++;
    URL url = getClass().getClassLoader().getResource("");
    String f = String.format(
        "%s%s.%s%s",
        url.getFile(),
        object.getClass().getName(),
        ext.contains("full") ? "" : counter + ".",
            ext
        );
    return new File(f);
	}
	
	 protected OutputStream getResourceStream(Object object,String ext) throws IOException {		 
		 return new FileOutputStream(getOutputFile(object, ext));
	 }

}
