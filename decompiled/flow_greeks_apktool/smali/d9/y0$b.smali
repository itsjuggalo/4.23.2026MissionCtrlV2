.class public Ld9/y0$b;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ld9/y0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "b"
.end annotation


# instance fields
.field public a:Ld9/a1;


# direct methods
.method public constructor <init>()V
    .locals 1

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    invoke-static {}, Ld9/z0;->a()Ld9/z0$b;

    move-result-object v0

    invoke-virtual {v0}, Ld9/z0$b;->a()Ld9/z0;

    move-result-object v0

    iput-object v0, p0, Ld9/y0$b;->a:Ld9/a1;

    return-void
.end method

.method public synthetic constructor <init>(Ld9/y0$a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ld9/y0$b;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ld9/y0;
    .locals 3

    .line 1
    new-instance v0, Ld9/y0;

    .line 2
    .line 3
    iget-object v1, p0, Ld9/y0$b;->a:Ld9/a1;

    .line 4
    .line 5
    const/4 v2, 0x0

    .line 6
    invoke-direct {v0, v1, v2}, Ld9/y0;-><init>(Ld9/a1;Ld9/y0$a;)V

    .line 7
    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
.end method
