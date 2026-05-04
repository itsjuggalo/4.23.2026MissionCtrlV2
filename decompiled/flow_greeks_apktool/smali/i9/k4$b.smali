.class public Li9/k4$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Li9/k4;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public a:Lg8/e;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 2
    invoke-static {}, Lj9/k;->h()Lg8/e;

    move-result-object v0

    iput-object v0, p0, Li9/k4$b;->a:Lg8/e;

    return-void
.end method

.method public synthetic constructor <init>(Li9/k4$a;)V
    .locals 0

    .line 3
    invoke-direct {p0}, Li9/k4$b;-><init>()V

    return-void
.end method
