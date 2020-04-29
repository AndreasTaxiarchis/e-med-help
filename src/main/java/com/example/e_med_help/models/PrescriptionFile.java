package com.example.e_med_help.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "prescription_file", schema = "emedhelp", catalog = "")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PrescriptionFile.findAll", query = "SELECT p FROM PrescriptionFile p"),
        @NamedQuery(name = "PrescriptionFile.findByFId", query = "SELECT p FROM PrescriptionFile p WHERE p.fId = :fId"),
        @NamedQuery(name = "PrescriptionFile.findByFDName", query = "SELECT p FROM PrescriptionFile p WHERE p.fDName = :fDName"),
        @NamedQuery(name = "PrescriptionFile.findByFDSurname", query = "SELECT p FROM PrescriptionFile p WHERE p.fDSurname = :fDSurname"),
        @NamedQuery(name = "PrescriptionFile.findByFPFullname", query = "SELECT p FROM PrescriptionFile p WHERE p.fPFullname = :fPFullname"),
        @NamedQuery(name = "PrescriptionFile.findByFFileName", query = "SELECT p FROM PrescriptionFile p WHERE p.fFileName = :fFileName")})
public class PrescriptionFile implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "F_ID")
    private Integer fId;
    @Size(max = 45)
    @Column(name = "F_D_NAME")
    private String fDName;
    @Size(max = 45)
    @Column(name = "F_D_SURNAME")
    private String fDSurname;
    @Size(max = 90)
    @Column(name = "F_P_FULLNAME")
    private String fPFullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "F_FILE_NAME")
    private String fFileName;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "F_DATA")
    private byte[] fData;
    @JoinColumn(name = "F_P_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private User fPId;
    @JoinColumn(name = "F_D_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private User fDId;
    @JoinColumn(name = "F_F_ID", referencedColumnName = "U_ID")
    @ManyToOne(optional = false)
    private User fFId;

    public PrescriptionFile() {
    }

    public PrescriptionFile(Integer fId, String fFileName, byte[] fData) {
        this.fId = fId;
        this.fFileName = fFileName;
        this.fData = fData;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public String getfDName() {
        return fDName;
    }

    public void setfDName(String fDName) {
        this.fDName = fDName;
    }

    public String getfDSurname() {
        return fDSurname;
    }

    public void setfDSurname(String fDSurname) {
        this.fDSurname = fDSurname;
    }

    public String getfPFullname() {
        return fPFullname;
    }

    public void setfPFullname(String fPFullname) {
        this.fPFullname = fPFullname;
    }

    public String getfFileName() {
        return fFileName;
    }

    public void setfFileName(String fFileName) {
        this.fFileName = fFileName;
    }

    public byte[] getfData() {
        return fData;
    }

    public void setfData(byte[] fData) {
        this.fData = fData;
    }

    public User getfPId() {
        return fPId;
    }

    public void setfPId(User fPId) {
        this.fPId = fPId;
    }

    public User getfDId() {
        return fDId;
    }

    public void setfDId(User fDId) {
        this.fDId = fDId;
    }

    public User getfFId() {
        return fFId;
    }

    public void setfFId(User fFId) {
        this.fFId = fFId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrescriptionFile that = (PrescriptionFile) o;
        return Objects.equals(fId, that.fId) &&
                Objects.equals(fDName, that.fDName) &&
                Objects.equals(fDSurname, that.fDSurname) &&
                Objects.equals(fPFullname, that.fPFullname) &&
                Objects.equals(fFileName, that.fFileName) &&
                Arrays.equals(fData, that.fData) &&
                Objects.equals(fPId, that.fPId) &&
                Objects.equals(fDId, that.fDId) &&
                Objects.equals(fFId, that.fFId);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(fId, fDName, fDSurname, fPFullname, fFileName, fPId, fDId, fFId);
        result = 31 * result + Arrays.hashCode(fData);
        return result;
    }
}