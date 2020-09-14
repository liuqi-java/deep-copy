package cn.com.sunboot;


import cn.com.sunboot.utils.ObjectCopyUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws Exception
    {

        UserModel model = new UserModel();
        List<UserAddressModel> addressModels = new ArrayList<>();
        UserAddressModel addressModel = new UserAddressModel();
        addressModel.setAddress("湖南长沙");
        addressModel.setId(1L);
        addressModel.setPhone("1234567890");
        addressModels.add(addressModel);
        model.setId(1L);
        model.setPassword("123456");
        model.setUserAddressModels(addressModels);
        model.setUsername("user");
        UserView userView = ObjectCopyUtil.deepCopy(model,UserView.class);

        System.out.println(userView.toString());
    }
}
