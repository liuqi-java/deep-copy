package cn.com.sunboot;

import cn.com.sunboot.annotation.FieldCopy;

import java.util.List;

/**
 * @author: liuqi
 * @date: 2020/9/14
 */
public class UserView {

    private Long id;
    private String username;

    @FieldCopy(name = "userAddressModels",source = UserModel.class)
    private List<UserAddressView> userAddressViews;

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


    public List<UserAddressView> getUserAddressViews() {
        return userAddressViews;
    }

    public void setUserAddressViews(List<UserAddressView> userAddressViews) {
        this.userAddressViews = userAddressViews;
    }

    @Override
    public String toString() {
        return "UserView{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userAddressViews=" + userAddressViews +
                '}';
    }
}
