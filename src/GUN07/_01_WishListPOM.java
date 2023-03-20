package GUN07;

import GUN06._03_PlaceOrderElements;
import Utility.BaseDriver;
import Utility.Tools;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_WishListPOM  extends BaseDriver {
    @Test
    @Parameters("searchText")
    void addToWishList(String text){
        _03_PlaceOrderElements poe=new _03_PlaceOrderElements();
        poe.searchBox.sendKeys(text);
        poe.searchButton.click();

        _02_WishListElements wle=new _02_WishListElements();

        int randomSecim=Tools.RandomGenerator(wle.searchResult.size());
        String wishItemText=wle.searchResult.get(randomSecim).getText();
        wle.wishButtonList.get(randomSecim).click();//tıklanacak elemanın ismini aldık
        wle.wishbtnProducts.click();
        Tools.listContainsString(wle.wishTableNames,wishItemText);

    }
}
