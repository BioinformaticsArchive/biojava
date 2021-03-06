/*
 *                    BioJava development code
 *
 * This code may be freely distributed and modified under the
 * terms of the GNU Lesser General Public Licence.  This should
 * be distributed with the code.  If you do not have a copy,
 * see:
 *
 *      http://www.gnu.org/copyleft/lesser.html
 *
 * Copyright for this code is held jointly by the individual
 * authors.  These should be listed in @author doc comments.
 *
 * For more information on the BioJava project and its aims,
 * or to join the biojava-l mailing list, visit the home page
 * at:
 *
 *      http://www.biojava.org/
 *
 * Created on 26.04.2004
 * @author Andreas Prlic
 *
 */
package org.biojava.bio.structure.io;

import java.io.File;
import java.io.IOException;

import org.biojava.bio.structure.Structure;

/**
 *  StructureIOFile defines a few methods that are useful when parsing PDB files from file system.
 * @author Andreas Prlic
 */
public interface StructureIOFile  {

	/** add a known File extension.
	 * @param ext  a String ...
	 */
	public void addExtension(String ext);

	/** clear all file extensions
	 *
	 */
	public void clearExtensions();

	/** 
	 * Open filename and returns
	 * a Structure object.
	 * @param filename  a String
	 * @return a Structure object
	 * @throws IOException ...
	 */
	public Structure getStructure(String filename) throws IOException ;

	/** 
	 * Read file from File and returns
	 * a Structure object.
	 * @param file file containing a PDB or mmcif file
	 * @return a Structure object
	 * @throws IOException ...
	 */
	public Structure getStructure(File file) throws IOException ;

	/** 
	 * Get a Structure by its PDB id. The reader takes care of finding the correct file in the PATH configured in get/setPath.
	 * @return a Structure object
	 */
	public Structure getStructureById(String pdbId) throws IOException;


	/** Set the parameters that should be used for file parsing
	 * 
	 * @param params FileParsingParameters
	 */
	public void setFileParsingParameters(FileParsingParameters params);


	/** Get the parameters that should be used for file parsing
	 * 
	 * @return the FileParsingParameters that are configuring the behavior of the parser
	 */
	public FileParsingParameters getFileParsingParameters();



}
