package org.biojava.bio.structure.quaternary.io;

public class BioUnitDataProviderFactory {
	//private static QuaternaryDataProvider provider = new MmCifBiolAssemblyProvider();
	private static String providerClassName = "org.biojava.bio.structure.quaternary.io.MmCifBiolAssemblyProvider"; 
	
	private BioUnitDataProviderFactory(){
		
	}
	
	public static BioUnitDataProvider getBioUnitDataProvider() {
		
		// use reflection to return a new instance...
		
		try {
			Class cls = Class.forName(providerClassName);
			
			return (BioUnitDataProvider) cls.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}

	public static void setBioUnitDataProvider(String className) {
		
		try {
			Class cls = Class.forName(providerClassName);
			Class interfaceClass = Class.forName("org.biojava.bio.structure.quaternary.io.BioUnitDataProvider");
			Class[] ifs = cls.getInterfaces();
			boolean found = false;
			for ( Class c : ifs){
				if ( c.equals(interfaceClass)){
					found = true;
					break;
				}
				
			}
			if ( ! found){
				System.err.println("The provided class " + className + " does not implement the correct interface!");
				return ;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// we do not set classes that don't exist!
			return;
		
		}
		providerClassName = className;
	}
	
	
}