.class public Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Lio/flutter/embedding/engine/plugins/FlutterPlugin;
.implements Lio/flutter/embedding/engine/plugins/activity/ActivityAware;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;,
        Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$CredentialManagerFactory;,
        Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$AuthorizationClientFactory;,
        Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$GoogleIdCredentialConverter;
    }
.end annotation


# static fields
.field private static final GOOGLE_ACCOUNT_TYPE:Ljava/lang/String; = "com.google"


# instance fields
.field private activityPluginBinding:Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;

.field private delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

.field private messenger:Lio/flutter/plugin/common/BinaryMessenger;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method

.method public static synthetic a(Landroid/content/Context;)Lc5/a;
    .locals 0

    .line 1
    invoke-static {p0}, Lc5/i;->a(Landroid/content/Context;)Lc5/a;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
    .line 6
    .line 7
    .line 8
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
.end method

.method private attachToActivity(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V
    .locals 1

    .line 1
    iput-object p1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->activityPluginBinding:Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;

    .line 2
    .line 3
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 4
    .line 5
    invoke-interface {p1, v0}, Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;->addActivityResultListener(Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 9
    .line 10
    invoke-interface {p1}, Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;->getActivity()Landroid/app/Activity;

    .line 11
    .line 12
    .line 13
    move-result-object p1

    .line 14
    invoke-virtual {v0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;->setActivity(Landroid/app/Activity;)V

    .line 15
    .line 16
    .line 17
    return-void
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public static synthetic b(Landroid/content/Context;)Lx0/d;
    .locals 0

    .line 1
    invoke-static {p0}, Lx0/d;->create(Landroid/content/Context;)Lx0/d;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    return-object p0
    .line 6
    .line 7
    .line 8
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
.end method

.method public static synthetic c(Lx0/c;)Lj6/c;
    .locals 0

    .line 1
    invoke-virtual {p0}, Lx0/c;->a()Landroid/os/Bundle;

    .line 2
    .line 3
    .line 4
    move-result-object p0

    .line 5
    invoke-static {p0}, Lj6/c;->c(Landroid/os/Bundle;)Lj6/c;

    .line 6
    .line 7
    .line 8
    move-result-object p0

    .line 9
    return-object p0
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
.end method

.method private dispose()V
    .locals 3

    .line 1
    const/4 v0, 0x0

    .line 2
    iput-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 3
    .line 4
    iget-object v1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->messenger:Lio/flutter/plugin/common/BinaryMessenger;

    .line 5
    .line 6
    if-eqz v1, :cond_0

    .line 7
    .line 8
    sget-object v2, Lio/flutter/plugins/googlesignin/GoogleSignInApi;->Companion:Lio/flutter/plugins/googlesignin/GoogleSignInApi$Companion;

    .line 9
    .line 10
    invoke-virtual {v2, v1, v0}, Lio/flutter/plugins/googlesignin/GoogleSignInApi$Companion;->setUp(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/googlesignin/GoogleSignInApi;)V

    .line 11
    .line 12
    .line 13
    iput-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->messenger:Lio/flutter/plugin/common/BinaryMessenger;

    .line 14
    .line 15
    :cond_0
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method private disposeActivity()V
    .locals 2

    .line 1
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->activityPluginBinding:Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;

    .line 2
    .line 3
    iget-object v1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 4
    .line 5
    invoke-interface {v0, v1}, Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;->removeActivityResultListener(Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;)V

    .line 6
    .line 7
    .line 8
    iget-object v0, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 9
    .line 10
    const/4 v1, 0x0

    .line 11
    invoke-virtual {v0, v1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;->setActivity(Landroid/app/Activity;)V

    .line 12
    .line 13
    .line 14
    iput-object v1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->activityPluginBinding:Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;

    .line 15
    .line 16
    return-void
    .line 17
    .line 18
    .line 19
.end method

.method private initInstance(Lio/flutter/plugin/common/BinaryMessenger;Landroid/content/Context;)V
    .locals 4

    .line 1
    new-instance v0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 2
    .line 3
    new-instance v1, Lio/flutter/plugins/googlesignin/m;

    .line 4
    .line 5
    invoke-direct {v1}, Lio/flutter/plugins/googlesignin/m;-><init>()V

    .line 6
    .line 7
    .line 8
    new-instance v2, Lio/flutter/plugins/googlesignin/n;

    .line 9
    .line 10
    invoke-direct {v2}, Lio/flutter/plugins/googlesignin/n;-><init>()V

    .line 11
    .line 12
    .line 13
    new-instance v3, Lio/flutter/plugins/googlesignin/o;

    .line 14
    .line 15
    invoke-direct {v3}, Lio/flutter/plugins/googlesignin/o;-><init>()V

    .line 16
    .line 17
    .line 18
    invoke-direct {v0, p2, v1, v2, v3}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;-><init>(Landroid/content/Context;Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$CredentialManagerFactory;Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$AuthorizationClientFactory;Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$GoogleIdCredentialConverter;)V

    .line 19
    .line 20
    .line 21
    invoke-virtual {p0, p1, v0}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->initWithDelegate(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;)V

    .line 22
    .line 23
    .line 24
    return-void
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
.method public initWithDelegate(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;)V
    .locals 1

    .line 1
    iput-object p1, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->messenger:Lio/flutter/plugin/common/BinaryMessenger;

    .line 2
    .line 3
    iput-object p2, p0, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->delegate:Lio/flutter/plugins/googlesignin/GoogleSignInPlugin$Delegate;

    .line 4
    .line 5
    sget-object v0, Lio/flutter/plugins/googlesignin/GoogleSignInApi;->Companion:Lio/flutter/plugins/googlesignin/GoogleSignInApi$Companion;

    .line 6
    .line 7
    invoke-virtual {v0, p1, p2}, Lio/flutter/plugins/googlesignin/GoogleSignInApi$Companion;->setUp(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/googlesignin/GoogleSignInApi;)V

    .line 8
    .line 9
    .line 10
    return-void
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

.method public onAttachedToActivity(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->attachToActivity(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method

.method public onAttachedToEngine(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V
    .locals 1

    .line 1
    invoke-virtual {p1}, Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;->getBinaryMessenger()Lio/flutter/plugin/common/BinaryMessenger;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    invoke-virtual {p1}, Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;->getApplicationContext()Landroid/content/Context;

    .line 6
    .line 7
    .line 8
    move-result-object p1

    .line 9
    invoke-direct {p0, v0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->initInstance(Lio/flutter/plugin/common/BinaryMessenger;Landroid/content/Context;)V

    .line 10
    .line 11
    .line 12
    return-void
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
.end method

.method public onDetachedFromActivity()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->disposeActivity()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method

.method public onDetachedFromActivityForConfigChanges()V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->disposeActivity()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method

.method public onDetachedFromEngine(Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->dispose()V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method

.method public onReattachedToActivityForConfigChanges(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V
    .locals 0

    .line 1
    invoke-direct {p0, p1}, Lio/flutter/plugins/googlesignin/GoogleSignInPlugin;->attachToActivity(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V

    .line 2
    .line 3
    .line 4
    return-void
    .line 5
    .line 6
    .line 7
    .line 8
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
.end method
