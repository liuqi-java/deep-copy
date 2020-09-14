package cn.com.sunboot;

import cn.com.sunboot.annotation.ObjectCopy;

/**
 * @author: liuqi
 * @date: 2020/9/14
 */
public class UserAddressModel {

    private Long id;
    private String address;
    private String phone;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
