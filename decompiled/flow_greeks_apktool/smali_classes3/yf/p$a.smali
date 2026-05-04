.class public final Lyf/p$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lyf/p;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# static fields
.field public static final synthetic a:Lyf/p$a;

.field public static final b:Lyf/q;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .line 1
    new-instance v0, Lyf/p$a;

    .line 2
    .line 3
    invoke-direct {v0}, Lyf/p$a;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lyf/p$a;->a:Lyf/p$a;

    .line 7
    .line 8
    new-instance v0, Lyf/q;

    .line 9
    .line 10
    sget-object v1, Lyf/g$a;->a:Lyf/g$a;

    .line 11
    .line 12
    const/4 v2, 0x0

    .line 13
    const/4 v3, 0x2

    .line 14
    invoke-direct {v0, v1, v2, v3, v2}, Lyf/q;-><init>(Lyf/g;Lyf/f;ILkotlin/jvm/internal/k;)V

    .line 15
    .line 16
    .line 17
    sput-object v0, Lyf/p$a;->b:Lyf/q;

    .line 18
    .line 19
    return-void
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
.method public final a()Lyf/q;
    .locals 1

    .line 1
    sget-object v0, Lyf/p$a;->b:Lyf/q;

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
