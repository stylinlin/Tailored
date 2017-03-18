package com.stylelin.tailored.Utils;

/**
 * 创建人:Jonlin
 * 创建时间:2016年7月14日 上午10:59:55
 * 类描述:跟App相关的辅助类
 */
public class UrlUtils {

    public static String http;
    public static String httpPic;
    public static String httpApk;
    public static final String httpBeta = "http://140.206.155.114:9080/exteriorline-phone";
//    public static final String httpBeta = "http://172.16.70.26:8080";
//    public static final String httpBeta = "http://172.16.70.27:8083";
//    public static final String httpBeta = "http://172.16.70.39:8080";

    public static final String updateappInterface = "/version/getLatestVersion.do";
    public static final String checkloginInterface = "/session/checkLogin.do";
    public static final String signingetvalicodeInterface = "/regist/getValicodeForRegist.do";
    public static final String signincheckphonenumInterface = "/regist/preRegistDriver.do";
    public static final String signinInterface = "/regist/registDriver.do";
    public static final String loginInterface = "/session/loginDriver.do";
    public static final String forgetpwdgetvalicodeInterface = "/session/getValicodeForForgetPwd.do";
    public static final String forgetpwdcheckphonenumInterface = "/session/preForgetPwd.do";
    public static final String forgetpwdInterface = "/session/forgetPwd.do";
    public static final String editphonenumgetvalicodeInterface = "/user/getValicodeForChangeMobileDriver.do";
    public static final String editphonenumInterface = "/user/changeMobileDriver.do";
    public static final String editpwdInterface = "/user/changePwd.do";
    public static final String loginoutInterface = "/session/loginout.do";
    public static final String getbannerpicInterface = "/banner/getHomepageBanner.do";
    public static final String goodsourcelistInterface = "/supplyGoods/findSupplyGoodsList.do";
    public static final String goodsourceinfoInterface = "/supplyGoods/findGoodsDetail.do";
    public static final String offerInterface = "/preOrder/quote.do";
    public static final String myofferlistInterface = "/preOrder/findPreOrderListShipper.do";
    public static final String uploadheadpicInterface = "/user/uploadHeadImg.do";
    public static final String getInvitationcodeInterface = "/invitationCode/getInvitationCode.do";
    public static final String getInvitationcodebonuseslistInterface = "/invitationCode/queryInvitationCodeList.do";
    public static final String logingetvalicodeInterface = "/session/getValicodeForLogin.do";
    public static final String vaildecodeloginInterface = "/session/loginPhoneCode.do";
    public static final String setloginpwdInterface = "/user/setLoginPassword.do";
    public static final String setusernameInterface = "/user/setUserName.do";
    public static final String relatedcompanylistInterface = "/user/getUserList.do";
    public static final String agreerelatedlistInterface = "/user/confirmRelate.do";

    public static final String xinLianPay = "/pay/xinLianPay.do";
    public static final String individualInfoAuthOneInterface = "/driver/checkIdcardNumberByDriver.do";
    public static final String individualInfoAuthInterface = "/auth/individualInfoAuth.do";
    public static final String individualVehicleAuthInterface = "/auth/individualVehicleAuth.do";
    public static final String kAddLine = "/busline/addBusLine.do";
    public static final String queryIndividualInfoInterface = "/auth/queryIndividualInfoAuth.do";
    public static final String individualVehicleInfoInterface = "/auth/queryIndividualVehicleAuth.do";
    public static final String kMyLines = "/busline/selfBusLineList.do";
    public static final String kDeleteLine = "/busline/delBusLineById.do";
    public static final String carrierAllOrder = "/order/findOrderListShipper.do";
    public static final String orderdetailInterface = "/order/findOrderDetails.do";
    public static final String kGetSignInfo = "/sign/findArrivalSignByOrderId.do";
    public static final String confirmSignInterface = "/order/confirmReceive.do";
    public static final String carrierAccOrder = "/order/acceptOrder.do";
    public static final String driversignInterface = "/sign/sign.do";
    public static final String kGetBalance = "/wallet/findBalance.do";
    public static final String kRecharge = "/wallet/recharge.do";
    public static final String kWithDrawals = "/withdraw/withdraw.do";
    public static final String kGetWalletRecordList = "/walletRecord/findWalletRecordList.do";
    public static final String kUploadReceipt = "/receipt/receipt.do";
    public static final String kGetReceiptList = "/receipt/findOrderListForReceipt.do";
    public static final String kGetReceiptByOrderId = "/receipt/findReceiptByOrderId.do";
    public static final String kGetIndividualInfo = "/auth/queryIndividualInfoAuth.do";
    public static final String kGetVehicleInfo = "/auth/queryIndividualVehicleAuth.do";
    public static final String kConfirmReceipt = "/order/sureReceipt.do";
    public static final String kDriverOrderList = "/order/findOrderListDriver.do";
    public static final String confirmcanvassInterface = "/order/canvassion.do";

    public static final String taskLanhuoInterface = "/vehicle/findDispatchList.do";
    public static final String taskDetailInterface = "/vehicle/findDispatchDetail.do";
    
//    public static final String kAddDriver = "/driver/saveDriver.do";// 添加司机
    public static final String kRealativeDreiver = "/driver/relatedDriver.do";// 司机关联
    public static final String kCancleRealativeDreiver = "/driver/deleteDriverInf.do";// 司机取消关联
    public static final String activeLocation = "/cartrack/orderAndActivateLocation.do";
    public static final String kRelativeCar = "/vehicle/addRelateVehicle.do";// 关联车辆
    public static final String kCheckCar = "/vehicle/findVehicleIsExist.do";// 查询车辆是否已存在
    public static final String kCancleRelativeCar = "/vehicle/cancleRelateVehicle.do";// 取消关联车辆
    
}