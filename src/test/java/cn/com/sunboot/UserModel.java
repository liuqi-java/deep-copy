package cn.com.sunboot;

import java.util.List;

/**
 * @author: liuqi
 * @date: 2020/9/14
 */
public class UserModel {

    private Long id;
    private String username;
    private String password;

    private List<UserAddressModel> userAddressModels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserAddressModel> getUserAddressModels() {
        return userAddressModels;
    }

    public void setUserAddressModels(List<UserAddressModel> userAddressModels) {
        this.userAddressModels = userAddressModels;
    }
}
