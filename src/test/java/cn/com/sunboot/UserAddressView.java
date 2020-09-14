package cn.com.sunboot;

import cn.com.sunboot.annotation.ObjectCopy;

/**
 * @author: liuqi
 * @date: 2020/9/14
 */
@ObjectCopy
public class UserAddressView {
    private Long id;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserAddressView{" +
                "id=" + id +
                ", address='" + address + '\'' +
                '}';
    }
}
