.class public final Lq5/b;
.super Ln5/a;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator<",
            "Lq5/b;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final a:I

.field public final b:Lq5/a;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 1
    new-instance v0, Lq5/c;

    .line 2
    .line 3
    invoke-direct {v0}, Lq5/c;-><init>()V

    .line 4
    .line 5
    .line 6
    sput-object v0, Lq5/b;->CREATOR:Landroid/os/Parcelable$Creator;

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
.end method

.method public constructor <init>(ILq5/a;)V
    .locals 0

    .line 1
    invoke-direct {p0}, Ln5/a;-><init>()V

    iput p1, p0, Lq5/b;->a:I

    iput-object p2, p0, Lq5/b;->b:Lq5/a;

    return-void
.end method

.method public constructor <init>(Lq5/a;)V
    .locals 1

    .line 2
    invoke-direct {p0}, Ln5/a;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lq5/b;->a:I

    iput-object p1, p0, Lq5/b;->b:Lq5/a;

    return-void
.end method

.method public static R(Lr5/a$b;)Lq5/b;
    .locals 1

    .line 1
    instance-of v0, p0, Lq5/a;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    new-instance v0, Lq5/b;

    .line 6
    .line 7
    check-cast p0, Lq5/a;

    .line 8
    .line 9
    invoke-direct {v0, p0}, Lq5/b;-><init>(Lq5/a;)V

    .line 10
    .line 11
    .line 12
    return-object v0

    .line 13
    :cond_0
    new-instance p0, Ljava/lang/IllegalArgumentException;

    .line 14
    .line 15
    const-string v0, "Unsupported safe parcelable field converter class."

    .line 16
    .line 17
    invoke-direct {p0, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    .line 18
    .line 19
    .line 20
    throw p0
    .line 21
    .line 22
    .line 23
    .line 24
.end method


# virtual methods
.method public final S()Lr5/a$b;
    .locals 2

    .line 1
    iget-object v0, p0, Lq5/b;->b:Lq5/a;

    .line 2
    .line 3
    if-eqz v0, :cond_0

    .line 4
    .line 5
    return-object v0

    .line 6
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    .line 7
    .line 8
    const-string v1, "There was no converter wrapped in this ConverterWrapper."

    .line 9
    .line 10
    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    .line 11
    .line 12
    .line 13
    throw v0
    .line 14
    .line 15
    .line 16
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 4

    .line 1
    iget v0, p0, Lq5/b;->a:I

    .line 2
    .line 3
    invoke-static {p1}, Ln5/c;->a(Landroid/os/Parcel;)I

    .line 4
    .line 5
    .line 6
    move-result v1

    .line 7
    const/4 v2, 0x1

    .line 8
    invoke-static {p1, v2, v0}, Ln5/c;->t(Landroid/os/Parcel;II)V

    .line 9
    .line 10
    .line 11
    iget-object v0, p0, Lq5/b;->b:Lq5/a;

    .line 12
    .line 13
    const/4 v2, 0x0

    .line 14
    const/4 v3, 0x2

    .line 15
    invoke-static {p1, v3, v0, p2, v2}, Ln5/c;->C(Landroid/os/Parcel;ILandroid/os/Parcelable;IZ)V

    .line 16
    .line 17
    .line 18
    invoke-static {p1, v1}, Ln5/c;->b(Landroid/os/Parcel;I)V

    .line 19
    .line 20
    .line 21
    return-void
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
.end method
