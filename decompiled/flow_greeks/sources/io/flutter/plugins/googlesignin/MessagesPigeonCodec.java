package io.flutter.plugins.googlesignin;

import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/flutter/plugins/googlesignin/MessagesPigeonCodec;", "Lio/flutter/plugin/common/StandardMessageCodec;", "<init>", "()V", "", "type", "Ljava/nio/ByteBuffer;", "buffer", "", "readValueOfType", "(BLjava/nio/ByteBuffer;)Ljava/lang/Object;", "Ljava/io/ByteArrayOutputStream;", "stream", "value", "Lcd/h0;", "writeValue", "(Ljava/io/ByteArrayOutputStream;Ljava/lang/Object;)V", "google_sign_in_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
class MessagesPigeonCodec extends StandardMessageCodec {
    @Override // io.flutter.plugin.common.StandardMessageCodec
    public Object readValueOfType(byte type, ByteBuffer buffer) {
        kotlin.jvm.internal.t.f(buffer, "buffer");
        if (type == -127) {
            Long l10 = (Long) readValue(buffer);
            if (l10 != null) {
                return GetCredentialFailureType.INSTANCE.ofRaw((int) l10.longValue());
            }
            return null;
        }
        if (type == -126) {
            Long l11 = (Long) readValue(buffer);
            if (l11 != null) {
                return AuthorizeFailureType.INSTANCE.ofRaw((int) l11.longValue());
            }
            return null;
        }
        if (type == -125) {
            Object value = readValue(buffer);
            List<? extends Object> list = value instanceof List ? (List) value : null;
            if (list != null) {
                return PlatformAuthorizationRequest.INSTANCE.fromList(list);
            }
            return null;
        }
        if (type == -124) {
            Object value2 = readValue(buffer);
            List<? extends Object> list2 = value2 instanceof List ? (List) value2 : null;
            if (list2 != null) {
                return GetCredentialRequestParams.INSTANCE.fromList(list2);
            }
            return null;
        }
        if (type == -123) {
            Object value3 = readValue(buffer);
            List<? extends Object> list3 = value3 instanceof List ? (List) value3 : null;
            if (list3 != null) {
                return GetCredentialRequestGoogleIdOptionParams.INSTANCE.fromList(list3);
            }
            return null;
        }
        if (type == -122) {
            Object value4 = readValue(buffer);
            List<? extends Object> list4 = value4 instanceof List ? (List) value4 : null;
            if (list4 != null) {
                return PlatformRevokeAccessRequest.INSTANCE.fromList(list4);
            }
            return null;
        }
        if (type == -121) {
            Object value5 = readValue(buffer);
            List<? extends Object> list5 = value5 instanceof List ? (List) value5 : null;
            if (list5 != null) {
                return PlatformGoogleIdTokenCredential.INSTANCE.fromList(list5);
            }
            return null;
        }
        if (type == -120) {
            Object value6 = readValue(buffer);
            List<? extends Object> list6 = value6 instanceof List ? (List) value6 : null;
            if (list6 != null) {
                return GetCredentialFailure.INSTANCE.fromList(list6);
            }
            return null;
        }
        if (type == -119) {
            Object value7 = readValue(buffer);
            List<? extends Object> list7 = value7 instanceof List ? (List) value7 : null;
            if (list7 != null) {
                return GetCredentialSuccess.INSTANCE.fromList(list7);
            }
            return null;
        }
        if (type == -118) {
            Object value8 = readValue(buffer);
            List<? extends Object> list8 = value8 instanceof List ? (List) value8 : null;
            if (list8 != null) {
                return AuthorizeFailure.INSTANCE.fromList(list8);
            }
            return null;
        }
        if (type != -117) {
            return super.readValueOfType(type, buffer);
        }
        Object value9 = readValue(buffer);
        List<? extends Object> list9 = value9 instanceof List ? (List) value9 : null;
        if (list9 != null) {
            return PlatformAuthorizationResult.INSTANCE.fromList(list9);
        }
        return null;
    }

    @Override // io.flutter.plugin.common.StandardMessageCodec
    public void writeValue(ByteArrayOutputStream stream, Object value) {
        kotlin.jvm.internal.t.f(stream, "stream");
        if (value instanceof GetCredentialFailureType) {
            stream.write(129);
            writeValue(stream, Long.valueOf(((GetCredentialFailureType) value).getRaw()));
            return;
        }
        if (value instanceof AuthorizeFailureType) {
            stream.write(130);
            writeValue(stream, Long.valueOf(((AuthorizeFailureType) value).getRaw()));
            return;
        }
        if (value instanceof PlatformAuthorizationRequest) {
            stream.write(131);
            writeValue(stream, ((PlatformAuthorizationRequest) value).toList());
            return;
        }
        if (value instanceof GetCredentialRequestParams) {
            stream.write(132);
            writeValue(stream, ((GetCredentialRequestParams) value).toList());
            return;
        }
        if (value instanceof GetCredentialRequestGoogleIdOptionParams) {
            stream.write(133);
            writeValue(stream, ((GetCredentialRequestGoogleIdOptionParams) value).toList());
            return;
        }
        if (value instanceof PlatformRevokeAccessRequest) {
            stream.write(134);
            writeValue(stream, ((PlatformRevokeAccessRequest) value).toList());
            return;
        }
        if (value instanceof PlatformGoogleIdTokenCredential) {
            stream.write(135);
            writeValue(stream, ((PlatformGoogleIdTokenCredential) value).toList());
            return;
        }
        if (value instanceof GetCredentialFailure) {
            stream.write(136);
            writeValue(stream, ((GetCredentialFailure) value).toList());
            return;
        }
        if (value instanceof GetCredentialSuccess) {
            stream.write(137);
            writeValue(stream, ((GetCredentialSuccess) value).toList());
        } else if (value instanceof AuthorizeFailure) {
            stream.write(138);
            writeValue(stream, ((AuthorizeFailure) value).toList());
        } else if (!(value instanceof PlatformAuthorizationResult)) {
            super.writeValue(stream, value);
        } else {
            stream.write(139);
            writeValue(stream, ((PlatformAuthorizationResult) value).toList());
        }
    }
}
