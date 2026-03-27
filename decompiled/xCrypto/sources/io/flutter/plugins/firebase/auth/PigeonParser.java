package io.flutter.plugins.firebase.auth;

import android.net.Uri;
import com.google.firebase.auth.ActionCodeEmailInfo;
import com.google.firebase.auth.ActionCodeInfo;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.GithubAuthProvider;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.OAuthCredential;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.PlayGamesAuthProvider;
import com.google.firebase.auth.TwitterAuthProvider;
import com.google.firebase.auth.UserInfo;
import io.flutter.plugins.firebase.auth.GeneratedAndroidFirebaseAuth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class PigeonParser {
    public static ActionCodeSettings getActionCodeSettings(GeneratedAndroidFirebaseAuth.PigeonActionCodeSettings pigeonActionCodeSettings) {
        ActionCodeSettings.Builder builderNewBuilder = ActionCodeSettings.newBuilder();
        builderNewBuilder.setUrl(pigeonActionCodeSettings.getUrl());
        if (pigeonActionCodeSettings.getDynamicLinkDomain() != null) {
            builderNewBuilder.setDynamicLinkDomain(pigeonActionCodeSettings.getDynamicLinkDomain());
        }
        if (pigeonActionCodeSettings.getLinkDomain() != null) {
            builderNewBuilder.setLinkDomain(pigeonActionCodeSettings.getLinkDomain());
        }
        builderNewBuilder.setHandleCodeInApp(pigeonActionCodeSettings.getHandleCodeInApp().booleanValue());
        if (pigeonActionCodeSettings.getAndroidPackageName() != null) {
            builderNewBuilder.setAndroidPackageName(pigeonActionCodeSettings.getAndroidPackageName(), pigeonActionCodeSettings.getAndroidInstallApp().booleanValue(), pigeonActionCodeSettings.getAndroidMinimumVersion());
        }
        if (pigeonActionCodeSettings.getIOSBundleId() != null) {
            builderNewBuilder.setIOSBundleId(pigeonActionCodeSettings.getIOSBundleId());
        }
        return builderNewBuilder.build();
    }

    public static AuthCredential getCredential(Map<String, Object> map) {
        String str;
        String str2;
        String str3;
        String str4;
        if (map.get("token") != null) {
            Integer num = (Integer) map.get("token");
            num.intValue();
            AuthCredential authCredential = FlutterFirebaseAuthPlugin.authCredentials.get(num);
            if (authCredential != null) {
                return authCredential;
            }
            throw FlutterFirebaseAuthPluginException.invalidCredential();
        }
        Object obj = map.get(Constants.SIGN_IN_METHOD);
        Objects.requireNonNull(obj);
        String str5 = (String) obj;
        str = (String) map.get(Constants.SECRET);
        str2 = (String) map.get(Constants.ID_TOKEN);
        str3 = (String) map.get(Constants.ACCESS_TOKEN);
        str4 = (String) map.get(Constants.RAW_NONCE);
        switch (str5) {
            case "twitter.com":
                Objects.requireNonNull(str3);
                Objects.requireNonNull(str);
                return TwitterAuthProvider.getCredential(str3, str);
            case "playgames.google.com":
                Object obj2 = map.get(Constants.SERVER_AUTH_CODE);
                Objects.requireNonNull(obj2);
                return PlayGamesAuthProvider.getCredential((String) obj2);
            case "google.com":
                return GoogleAuthProvider.getCredential(str2, str3);
            case "facebook.com":
                Objects.requireNonNull(str3);
                return FacebookAuthProvider.getCredential(str3);
            case "oauth":
                Object obj3 = map.get(Constants.PROVIDER_ID);
                Objects.requireNonNull(obj3);
                OAuthProvider.CredentialBuilder credentialBuilderNewCredentialBuilder = OAuthProvider.newCredentialBuilder((String) obj3);
                if (str3 != null) {
                    credentialBuilderNewCredentialBuilder.setAccessToken(str3);
                }
                if (str4 == null) {
                    Objects.requireNonNull(str2);
                    credentialBuilderNewCredentialBuilder.setIdToken(str2);
                } else {
                    Objects.requireNonNull(str2);
                    credentialBuilderNewCredentialBuilder.setIdTokenWithRawNonce(str2, str4);
                }
                return credentialBuilderNewCredentialBuilder.build();
            case "phone":
                Object obj4 = map.get(Constants.VERIFICATION_ID);
                Objects.requireNonNull(obj4);
                Object obj5 = map.get(Constants.SMS_CODE);
                Objects.requireNonNull(obj5);
                return PhoneAuthProvider.getCredential((String) obj4, (String) obj5);
            case "password":
                Object obj6 = map.get(Constants.EMAIL);
                Objects.requireNonNull(obj6);
                Objects.requireNonNull(str);
                return EmailAuthProvider.getCredential((String) obj6, str);
            case "github.com":
                Objects.requireNonNull(str3);
                return GithubAuthProvider.getCredential(str3);
            case "emailLink":
                Object obj7 = map.get(Constants.EMAIL);
                Objects.requireNonNull(obj7);
                Object obj8 = map.get("emailLink");
                Objects.requireNonNull(obj8);
                return EmailAuthProvider.getCredentialWithLink((String) obj7, (String) obj8);
            default:
                return null;
        }
    }

    public static List<Object> manuallyToList(GeneratedAndroidFirebaseAuth.PigeonUserDetails pigeonUserDetails) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(pigeonUserDetails.getUserInfo().toList());
        arrayList.add(pigeonUserDetails.getProviderData());
        return arrayList;
    }

    public static List<List<Object>> multiFactorInfoToMap(List<MultiFactorInfo> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo> it = multiFactorInfoToPigeon(list).iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toList());
        }
        return arrayList;
    }

    public static List<GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo> multiFactorInfoToPigeon(List<MultiFactorInfo> list) {
        ArrayList arrayList = new ArrayList();
        for (MultiFactorInfo multiFactorInfo : list) {
            if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                arrayList.add(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo.Builder().setPhoneNumber(((PhoneMultiFactorInfo) multiFactorInfo).getPhoneNumber()).setDisplayName(multiFactorInfo.getDisplayName()).setEnrollmentTimestamp(Double.valueOf(multiFactorInfo.getEnrollmentTimestamp())).setUid(multiFactorInfo.getUid()).setFactorId(multiFactorInfo.getFactorId()).build());
            } else {
                arrayList.add(new GeneratedAndroidFirebaseAuth.PigeonMultiFactorInfo.Builder().setDisplayName(multiFactorInfo.getDisplayName()).setEnrollmentTimestamp(Double.valueOf(multiFactorInfo.getEnrollmentTimestamp())).setUid(multiFactorInfo.getUid()).setFactorId(multiFactorInfo.getFactorId()).build());
            }
        }
        return arrayList;
    }

    public static GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo parseActionCodeResult(ActionCodeResult actionCodeResult) {
        GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonActionCodeInfo.Builder();
        GeneratedAndroidFirebaseAuth.PigeonActionCodeInfoData.Builder builder2 = new GeneratedAndroidFirebaseAuth.PigeonActionCodeInfoData.Builder();
        int operation = actionCodeResult.getOperation();
        if (operation == 0) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.PASSWORD_RESET);
        } else if (operation == 1) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.VERIFY_EMAIL);
        } else if (operation == 2) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.RECOVER_EMAIL);
        } else if (operation == 4) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.EMAIL_SIGN_IN);
        } else if (operation == 5) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.VERIFY_AND_CHANGE_EMAIL);
        } else if (operation == 6) {
            builder.setOperation(GeneratedAndroidFirebaseAuth.ActionCodeInfoOperation.REVERT_SECOND_FACTOR_ADDITION);
        }
        ActionCodeInfo info = actionCodeResult.getInfo();
        if ((info != null && operation == 1) || operation == 0) {
            builder2.setEmail(info.getEmail());
        } else if (operation == 2 || operation == 5) {
            Objects.requireNonNull(info);
            ActionCodeEmailInfo actionCodeEmailInfo = (ActionCodeEmailInfo) info;
            builder2.setEmail(actionCodeEmailInfo.getEmail());
            builder2.setPreviousEmail(actionCodeEmailInfo.getPreviousEmail());
        }
        builder.setData(builder2.build());
        return builder.build();
    }

    private static GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo parseAdditionalUserInfo(AdditionalUserInfo additionalUserInfo) {
        if (additionalUserInfo == null) {
            return null;
        }
        GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonAdditionalUserInfo.Builder();
        builder.setIsNewUser(Boolean.valueOf(additionalUserInfo.isNewUser()));
        builder.setProfile(additionalUserInfo.getProfile());
        builder.setProviderId(additionalUserInfo.getProviderId());
        builder.setUsername(additionalUserInfo.getUsername());
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonAuthCredential parseAuthCredential(AuthCredential authCredential) {
        if (authCredential == null) {
            return null;
        }
        int iHashCode = authCredential.hashCode();
        FlutterFirebaseAuthPlugin.authCredentials.put(Integer.valueOf(iHashCode), authCredential);
        GeneratedAndroidFirebaseAuth.PigeonAuthCredential.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonAuthCredential.Builder();
        builder.setProviderId(authCredential.getProvider());
        builder.setSignInMethod(authCredential.getSignInMethod());
        builder.setNativeId(Long.valueOf(iHashCode));
        if (authCredential instanceof OAuthCredential) {
            builder.setAccessToken(((OAuthCredential) authCredential).getAccessToken());
        }
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonUserCredential parseAuthResult(AuthResult authResult) {
        GeneratedAndroidFirebaseAuth.PigeonUserCredential.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonUserCredential.Builder();
        builder.setAdditionalUserInfo(parseAdditionalUserInfo(authResult.getAdditionalUserInfo()));
        builder.setCredential(parseAuthCredential(authResult.getCredential()));
        builder.setUser(parseFirebaseUser(authResult.getUser()));
        return builder.build();
    }

    public static GeneratedAndroidFirebaseAuth.PigeonUserDetails parseFirebaseUser(FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            return null;
        }
        GeneratedAndroidFirebaseAuth.PigeonUserDetails.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonUserDetails.Builder();
        GeneratedAndroidFirebaseAuth.PigeonUserInfo.Builder builder2 = new GeneratedAndroidFirebaseAuth.PigeonUserInfo.Builder();
        builder2.setDisplayName(firebaseUser.getDisplayName());
        builder2.setEmail(firebaseUser.getEmail());
        builder2.setIsEmailVerified(Boolean.valueOf(firebaseUser.isEmailVerified()));
        builder2.setIsAnonymous(Boolean.valueOf(firebaseUser.isAnonymous()));
        if (firebaseUser.getMetadata() != null) {
            builder2.setCreationTimestamp(Long.valueOf(firebaseUser.getMetadata().getCreationTimestamp()));
            builder2.setLastSignInTimestamp(Long.valueOf(firebaseUser.getMetadata().getLastSignInTimestamp()));
        }
        builder2.setPhoneNumber(firebaseUser.getPhoneNumber());
        builder2.setPhotoUrl(parsePhotoUrl(firebaseUser.getPhotoUrl()));
        builder2.setUid(firebaseUser.getUid());
        builder2.setTenantId(firebaseUser.getTenantId());
        builder.setUserInfo(builder2.build());
        builder.setProviderData(parseUserInfoList(firebaseUser.getProviderData()));
        return builder.build();
    }

    private static String parsePhotoUrl(Uri uri) {
        if (uri == null) {
            return null;
        }
        String string = uri.toString();
        if ("".equals(string)) {
            return null;
        }
        return string;
    }

    public static GeneratedAndroidFirebaseAuth.PigeonIdTokenResult parseTokenResult(GetTokenResult getTokenResult) {
        GeneratedAndroidFirebaseAuth.PigeonIdTokenResult.Builder builder = new GeneratedAndroidFirebaseAuth.PigeonIdTokenResult.Builder();
        builder.setToken(getTokenResult.getToken());
        builder.setSignInProvider(getTokenResult.getSignInProvider());
        builder.setAuthTimestamp(Long.valueOf(getTokenResult.getAuthTimestamp() * 1000));
        builder.setExpirationTimestamp(Long.valueOf(getTokenResult.getExpirationTimestamp() * 1000));
        builder.setIssuedAtTimestamp(Long.valueOf(getTokenResult.getIssuedAtTimestamp() * 1000));
        builder.setClaims(getTokenResult.getClaims());
        builder.setSignInSecondFactor(getTokenResult.getSignInSecondFactor());
        return builder.build();
    }

    private static List<Map<Object, Object>> parseUserInfoList(List<? extends UserInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return null;
        }
        for (UserInfo userInfo : new ArrayList(list)) {
            if (userInfo != null && !FirebaseAuthProvider.PROVIDER_ID.equals(userInfo.getProviderId())) {
                arrayList.add(parseUserInfoToMap(userInfo));
            }
        }
        return arrayList;
    }

    private static Map<Object, Object> parseUserInfoToMap(UserInfo userInfo) {
        HashMap map = new HashMap();
        map.put("displayName", userInfo.getDisplayName());
        map.put(Constants.EMAIL, userInfo.getEmail());
        map.put("isEmailVerified", Boolean.valueOf(userInfo.isEmailVerified()));
        map.put("phoneNumber", userInfo.getPhoneNumber());
        map.put("photoUrl", parsePhotoUrl(userInfo.getPhotoUrl()));
        map.put("uid", userInfo.getUid() == null ? "" : userInfo.getUid());
        map.put(Constants.PROVIDER_ID, userInfo.getProviderId());
        map.put("isAnonymous", Boolean.FALSE);
        return map;
    }
}
