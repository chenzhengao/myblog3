package myblog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

@Entity
@Table(name = "blogger", schema = "myblog", catalog = "")
public class BloggerEntity {
    private int id;
    private String name;
    private String nickname;
    private String psw;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
    private Timestamp createtime;
    private String deleteflag;
    private Integer detetorid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT-8")
    private Timestamp deletetime;
    private byte[] image;


    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "nickname", nullable = true, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "psw", nullable = true, length = 50)
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "createtime", nullable = true)
    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "deleteflag", nullable = true, length = 10)
    public String getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag;
    }

    @Basic
    @Column(name = "detetorid", nullable = true)
    public Integer getDetetorid() {
        return detetorid;
    }

    public void setDetetorid(Integer detetorid) {
        this.detetorid = detetorid;
    }

    @Basic
    @Column(name = "deletetime", nullable = true)
    public Timestamp getDeletetime() {
        return deletetime;
    }

    public void setDeletetime(Timestamp deletetime) {
        this.deletetime = deletetime;
    }

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "image")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloggerEntity blogger = (BloggerEntity) o;

        if (id != blogger.id) return false;
        if (name != null ? !name.equals(blogger.name) : blogger.name != null) return false;
        if (nickname != null ? !nickname.equals(blogger.nickname) : blogger.nickname != null) return false;
        if (psw != null ? !psw.equals(blogger.psw) : blogger.psw != null) return false;
        if (email != null ? !email.equals(blogger.email) : blogger.email != null) return false;
        if (createtime != null ? !createtime.equals(blogger.createtime) : blogger.createtime != null) return false;
        if (deleteflag != null ? !deleteflag.equals(blogger.deleteflag) : blogger.deleteflag != null) return false;
        if (detetorid != null ? !detetorid.equals(blogger.detetorid) : blogger.detetorid != null) return false;
        if (deletetime != null ? !deletetime.equals(blogger.deletetime) : blogger.deletetime != null) return false;
        if (!Arrays.equals(image, blogger.image)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "BloggerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", psw='" + psw + '\'' +
                ", email='" + email + '\'' +
                ", createtime=" + createtime +
                ", deleteflag='" + deleteflag + '\'' +
                ", detetorid=" + detetorid +
                ", deletetime=" + deletetime +
                ", image=" + Arrays.toString(image) +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (psw != null ? psw.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (deleteflag != null ? deleteflag.hashCode() : 0);
        result = 31 * result + (detetorid != null ? detetorid.hashCode() : 0);
        result = 31 * result + (deletetime != null ? deletetime.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
