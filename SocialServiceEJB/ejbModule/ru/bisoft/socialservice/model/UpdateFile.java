package ru.bisoft.socialservice.model;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "UPDATE_FILE")
@SequenceGenerator(name = "UPDATE_FILE_GEN_ID", sequenceName = "UPDATE_FILE_GEN_ID")
@XmlRootElement
@NamedQueries({ 
	@NamedQuery(name = "UpdateFile.getLastVersion", query = "SELECT MAX(u2.versionUpdateFile) FROM UpdateFile u2"), 
	@NamedQuery(name = "UpdateFile.getUpdateFile", query = "SELECT u FROM UpdateFile u WHERE u.versionUpdateFile = :versionUpdateFile") 
})
public class UpdateFile {

	@Id
	@Column(name = "KEY_UPDATE_FILE")
	@GeneratedValue(strategy = SEQUENCE, generator = "UPDATE_FILE_GEN_ID")
	private int keyUpdateFile;
	
	@Lob
	@Column(name = "DATA_UPDATE_FILE")
	private byte[] dataUpdateFile;
	
	@Column(name = "VERSION_UPDATE_FILE")
	private String versionUpdateFile;

	public UpdateFile() {
		super();
	}

	public int getKeyUpdateFile() {
		return keyUpdateFile;
	}

	public void setKeyUpdateFile(int keyUpdateFile) {
		this.keyUpdateFile = keyUpdateFile;
	}

	public byte[] getDataUpdateFile() {
		return dataUpdateFile;
	}

	public void setDataUpdateFile(byte[] dataUpdateFile) {
		this.dataUpdateFile = dataUpdateFile;
	}

	public String getVersionUpdateFile() {
		return versionUpdateFile;
	}

	public void setVersionUpdateFile(String versionUpdateFile) {
		this.versionUpdateFile = versionUpdateFile;
	}
	@XmlElement(name="sizeUpdateFile")
	public int getBinSize()
	{
		return dataUpdateFile.length;
	}
}
