.class Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lx0/e;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;->getCredential(Lio/flutter/plugins/googlesignin/GetCredentialRequestParams;Lpd/k;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lx0/e;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

.field final synthetic val$callback:Lpd/k;


# direct methods
.method public constructor <init>(Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;Lpd/k;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->this$0:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 2
    .line 3
    iput-object p2, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->val$callback:Lpd/k;

    .line 4
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 6
    .line 7
    .line 8
    return-void
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
    .line 40
    .line 41
    .line 42
    .line 43
    .line 44
    .line 45
    .line 46
    .line 47
    .line 48
.end method


# virtual methods
.method public bridge synthetic onError(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Ly0/h;

    invoke-virtual {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->onError(Ly0/h;)V

    return-void
.end method

.method public onError(Ly0/h;)V
    .locals 4

    .line 2
    instance-of v0, p1, Ly0/f;

    if-eqz v0, :cond_0

    .line 3
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->CANCELED:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    goto :goto_0

    .line 4
    :cond_0
    instance-of v0, p1, Ly0/i;

    if-eqz v0, :cond_1

    .line 5
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->INTERRUPTED:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    goto :goto_0

    .line 6
    :cond_1
    instance-of v0, p1, Ly0/j;

    if-eqz v0, :cond_2

    .line 7
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->PROVIDER_CONFIGURATION_ISSUE:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    goto :goto_0

    .line 8
    :cond_2
    instance-of v0, p1, Ly0/l;

    if-eqz v0, :cond_3

    .line 9
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->UNSUPPORTED:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    goto :goto_0

    .line 10
    :cond_3
    instance-of v0, p1, Ly0/m;

    if-eqz v0, :cond_4

    .line 11
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->NO_CREDENTIAL:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    goto :goto_0

    .line 12
    :cond_4
    sget-object v0, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->UNKNOWN:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    .line 13
    :goto_0
    iget-object v1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->val$callback:Lpd/k;

    new-instance v2, Lio/flutter/plugins/googlesignin/GetCredentialFailure;

    .line 14
    invoke-virtual {p1}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object p1

    const/4 v3, 0x0

    invoke-direct {v2, v0, p1, v3}, Lio/flutter/plugins/googlesignin/GetCredentialFailure;-><init>(Lio/flutter/plugins/googlesignin/GetCredentialFailureType;Ljava/lang/String;Ljava/lang/String;)V

    .line 15
    invoke-static {v1, v2}, Lio/flutter/plugins/googlesignin/ResultUtilsKt;->completeWithGetCredentialFailure(Lpd/k;Lio/flutter/plugins/googlesignin/GetCredentialFailure;)V

    return-void
.end method

.method public bridge synthetic onResult(Ljava/lang/Object;)V
    .locals 0

    .line 1
    check-cast p1, Lx0/x;

    invoke-virtual {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->onResult(Lx0/x;)V

    return-void
.end method

.method public onResult(Lx0/x;)V
    .locals 11

    .line 2
    invoke-virtual {p1}, Lx0/x;->a()Lx0/c;

    move-result-object p1

    .line 3
    instance-of v0, p1, Lx0/u;

    const/4 v1, 0x0

    if-eqz v0, :cond_1

    .line 4
    invoke-virtual {p1}, Lx0/c;->b()Ljava/lang/String;

    move-result-object v0

    const-string v2, "com.google.android.libraries.identity.googleid.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL"

    .line 5
    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 6
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->this$0:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    iget-object v0, v0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;->credentialConverter:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$GoogleIdCredentialConverter;

    .line 7
    invoke-interface {v0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$GoogleIdCredentialConverter;->createFrom(Lx0/c;)Lj6/c;

    move-result-object p1

    .line 8
    invoke-virtual {p1}, Lj6/c;->i()Landroid/net/Uri;

    move-result-object v0

    .line 9
    iget-object v2, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->val$callback:Lpd/k;

    new-instance v3, Lio/flutter/plugins/googlesignin/GetCredentialSuccess;

    new-instance v4, Lio/flutter/plugins/googlesignin/PlatformGoogleIdTokenCredential;

    .line 10
    invoke-virtual {p1}, Lj6/c;->d()Ljava/lang/String;

    move-result-object v5

    .line 11
    invoke-virtual {p1}, Lj6/c;->e()Ljava/lang/String;

    move-result-object v6

    .line 12
    invoke-virtual {p1}, Lj6/c;->f()Ljava/lang/String;

    move-result-object v7

    .line 13
    invoke-virtual {p1}, Lj6/c;->g()Ljava/lang/String;

    move-result-object v8

    .line 14
    invoke-virtual {p1}, Lj6/c;->h()Ljava/lang/String;

    move-result-object v9

    if-nez v0, :cond_0

    :goto_0
    move-object v10, v1

    goto :goto_1

    .line 15
    :cond_0
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    :goto_1
    invoke-direct/range {v4 .. v10}, Lio/flutter/plugins/googlesignin/PlatformGoogleIdTokenCredential;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {v3, v4}, Lio/flutter/plugins/googlesignin/GetCredentialSuccess;-><init>(Lio/flutter/plugins/googlesignin/PlatformGoogleIdTokenCredential;)V

    .line 16
    invoke-static {v2, v3}, Lio/flutter/plugins/googlesignin/ResultUtilsKt;->completeWithGetGetCredentialResult(Lpd/k;Lio/flutter/plugins/googlesignin/GetCredentialResult;)V

    return-void

    .line 17
    :cond_1
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate$1;->val$callback:Lpd/k;

    new-instance v2, Lio/flutter/plugins/googlesignin/GetCredentialFailure;

    sget-object v3, Lio/flutter/plugins/googlesignin/GetCredentialFailureType;->UNEXPECTED_CREDENTIAL_TYPE:Lio/flutter/plugins/googlesignin/GetCredentialFailureType;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unexpected credential type: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-direct {v2, v3, p1, v1}, Lio/flutter/plugins/googlesignin/GetCredentialFailure;-><init>(Lio/flutter/plugins/googlesignin/GetCredentialFailureType;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0, v2}, Lio/flutter/plugins/googlesignin/ResultUtilsKt;->completeWithGetCredentialFailure(Lpd/k;Lio/flutter/plugins/googlesignin/GetCredentialFailure;)V

    return-void
.end method
