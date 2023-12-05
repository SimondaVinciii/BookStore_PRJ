/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thinhhq.util;

/**
 *
 * @author ANDIM
 */
public class MyApplicationConstants {

    public class DispathFeature {

        public static final String LOGIN_PAGE = "";
        public static final String LOGIN_CONTROLLER = "loginController";
        public static final String SEARCH_LASTNAME_CONTROLLER = "searchController";
        public static final String ADD_ITEM_TO_CART_CONTROLLER = "addItemController";
        public static final String VIEW_ITEM_PAGE = "viewItemPage";
        public static final String REMOVE_ITEMS_FROM_CART = "removeItemController";
        public static final String CREATE_NEW_ACCOUNT = "createNewAccount";
        public static final String CHECK_OUT_CART = "CheckOutServlet";
        public static final String LOG_OUT_CONTROLLER = "logOutController";
        public static final String START_UP_CONTROLLER = "startUpController";
        public static final String DELETE_ACCOUNT_CONTROLLER = "deleteController";
        public static final String UPDATE_ACCOUNT_CONTROLLER = "updateController";
        public static final String SEARCH_PRODUCT_CONTROLLER="searchProductController";
    }

    public class LoginFeature {

        public static final String SEARCH_PAGE = "searchPage";
        public static final String INVALID_PAGE = "invalidPage";
    }

    public class SearchFeature {

        public static final String SEARCH_PAGE = "searchPage";
        public static final String RESULT_PAGE = "searchResultPage";
    }

    public class DeleteFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class UpdateFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class LogoutFeature {

        public static final String LOGIN_PAGE = "";
    }

    public class AddToCartFeature {

        public static final String SHOPPING_PAGE = "shoppingPage";
    }

    public class StartUpFeature {

        public static final String LOGIN_PAGE = "";
        public static final String RESULT_PAGE = "searchResultPage";
    }

    public class RemoveItemCartFeature {

        public static final String ERROR_PAGE = "errorPage";
    }

    public class CreateAccountFeature {

        public static final String CREATE_ACCOUNT_ERROR = "createAccErrPage";
        public static final String LOGIN_PAGE = "";
    }
}
