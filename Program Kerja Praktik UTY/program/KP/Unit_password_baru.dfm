object Form_ganti_password: TForm_ganti_password
  Left = 0
  Top = 0
  Caption = 'Form_ganti_password'
  ClientHeight = 223
  ClientWidth = 447
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel
    Left = 8
    Top = 8
    Width = 431
    Height = 207
    TabOrder = 0
    object Label1: TLabel
      Left = 176
      Top = 16
      Width = 91
      Height = 13
      Caption = 'GANTI PASSWORD'
    end
    object Label2: TLabel
      Left = 40
      Top = 56
      Width = 48
      Height = 13
      Caption = 'Username'
    end
    object Label3: TLabel
      Left = 42
      Top = 86
      Width = 46
      Height = 13
      Caption = 'Password'
    end
    object Label4: TLabel
      Left = 40
      Top = 115
      Width = 71
      Height = 13
      Caption = 'Password Baru'
    end
    object Label5: TLabel
      Left = 40
      Top = 147
      Width = 93
      Height = 13
      Caption = 'Konfirmasi pasword'
    end
    object Edit_username_lama: TEdit
      Left = 146
      Top = 53
      Width = 135
      Height = 21
      TabOrder = 0
      Text = 'Edit_username_lama'
    end
    object Edit_password_lama: TEdit
      Left = 146
      Top = 85
      Width = 135
      Height = 21
      TabOrder = 1
      Text = 'Edit_password_lama'
    end
    object Edit_password_baru: TEdit
      Left = 146
      Top = 112
      Width = 135
      Height = 21
      TabOrder = 2
      Text = 'Edit_password_baru'
    end
    object Edit_konfirmasi_pasword: TEdit
      Left = 146
      Top = 139
      Width = 135
      Height = 21
      TabOrder = 3
      Text = 'Edit_konfirmasi_pasword'
    end
    object Button_ubah_password_baru: TButton
      Left = 273
      Top = 171
      Width = 75
      Height = 25
      Caption = 'UBAH'
      TabOrder = 4
      OnClick = Button_ubah_password_baruClick
    end
    object Edit1: TEdit
      Left = 32
      Top = 16
      Width = 121
      Height = 21
      TabOrder = 5
      Text = 'Edit1'
      Visible = False
    end
  end
  object ADOQuery1: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 352
    Top = 72
  end
  object ADOGanti: TADOQuery
    Connection = Data_Module.ADOConnection1
    Parameters = <>
    Left = 368
    Top = 136
  end
end
