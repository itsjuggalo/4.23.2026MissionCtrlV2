.class public Ltb/g1$r;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "r"
.end annotation


# instance fields
.field public final synthetic a:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$r;->a:Ltb/g1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ltb/g1;Ltb/g1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Ltb/g1$r;-><init>(Ltb/g1;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$r;->a:Ltb/g1;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1;->w0(Ltb/g1;)Ltb/g1$s;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    if-nez v0, :cond_0

    .line 8
    .line 9
    return-void

    .line 10
    :cond_0
    iget-object v0, p0, Ltb/g1$r;->a:Ltb/g1;

    .line 11
    .line 12
    invoke-static {v0}, Ltb/g1;->o(Ltb/g1;)V

    .line 13
    .line 14
    .line 15
    return-void
    .line 16
    .line 17
    .line 18
    .line 19
.end method
