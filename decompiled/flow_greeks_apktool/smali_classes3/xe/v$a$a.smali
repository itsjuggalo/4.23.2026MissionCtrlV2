.class public final Lxe/v$a$a;
.super Lxe/v$a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lxe/v$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public final a:Lxe/x;

.field public final b:[B


# direct methods
.method public constructor <init>(Lxe/x;[B)V
    .locals 1

    const-string v0, "kotlinJvmBinaryClass"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 1
    invoke-direct {p0, v0}, Lxe/v$a;-><init>(Lkotlin/jvm/internal/k;)V

    iput-object p1, p0, Lxe/v$a$a;->a:Lxe/x;

    iput-object p2, p0, Lxe/v$a$a;->b:[B

    return-void
.end method

.method public synthetic constructor <init>(Lxe/x;[BILkotlin/jvm/internal/k;)V
    .locals 0

    and-int/lit8 p3, p3, 0x2

    if-eqz p3, :cond_0

    const/4 p2, 0x0

    .line 2
    :cond_0
    invoke-direct {p0, p1, p2}, Lxe/v$a$a;-><init>(Lxe/x;[B)V

    return-void
.end method


# virtual methods
.method public final b()Lxe/x;
    .locals 1

    .line 1
    iget-object v0, p0, Lxe/v$a$a;->a:Lxe/x;

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
