.class public final Lge/h$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lge/h;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# static fields
.field public static final synthetic a:Lge/h$a;

.field public static final b:Lge/h;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lge/h$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lge/h$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lge/h$a;->a:Lge/h$a;

    .line 7
    .line 8
    new-instance v0, Lge/h$a$a;

    .line 9
    .line 10
    invoke-direct {v0}, Lge/h$a$a;-><init>()V

    .line 11
    .line 12
    .line 13
    sput-object v0, Lge/h$a;->b:Lge/h;

    .line 14
    .line 15
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
.end method

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


# virtual methods
.method public final a(Ljava/util/List;)Lge/h;
    .locals 1

    .line 1
    const-string v0, "annotations"

    .line 2
    .line 3
    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    .line 7
    .line 8
    .line 9
    move-result v0

    .line 10
    if-eqz v0, :cond_0

    .line 11
    .line 12
    sget-object p1, Lge/h$a;->b:Lge/h;

    .line 13
    .line 14
    return-object p1

    .line 15
    :cond_0
    new-instance v0, Lge/i;

    .line 16
    .line 17
    invoke-direct {v0, p1}, Lge/i;-><init>(Ljava/util/List;)V

    .line 18
    .line 19
    .line 20
    return-object v0
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method

.method public final b()Lge/h;
    .locals 1

    .line 1
    sget-object v0, Lge/h$a;->b:Lge/h;

    .line 2
    .line 3
    return-object v0
    .line 4
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
