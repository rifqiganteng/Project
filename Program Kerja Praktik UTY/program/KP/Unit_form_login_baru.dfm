object Form_login_baru: TForm_login_baru
  Left = 0
  Top = 0
  Caption = 'Form_login_baru'
  ClientHeight = 238
  ClientWidth = 262
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  Position = poDesktopCenter
  OnShow = FormShow
  PixelsPerInch = 96
  TextHeight = 13
  object Panel1: TPanel
    Left = 8
    Top = 8
    Width = 249
    Height = 225
    Hint = 'Input User Name'
    TabOrder = 0
    object Edit_username_login: TEdit
      Left = 48
      Top = 29
      Width = 153
      Height = 24
      Hint = 'Input Username'
      Alignment = taCenter
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Lucida Console'
      Font.Style = []
      ParentFont = False
      ParentShowHint = False
      ShowHint = True
      TabOrder = 0
      TextHint = 'Input Username '
      OnClick = Edit_username_loginClick
    end
    object Edit_pasword_login: TEdit
      Left = 48
      Top = 72
      Width = 153
      Height = 24
      Hint = 'Input Password'
      Alignment = taCenter
      Font.Charset = DEFAULT_CHARSET
      Font.Color = clWindowText
      Font.Height = -16
      Font.Name = 'Lucida Console'
      Font.Style = []
      ParentFont = False
      ParentShowHint = False
      PasswordChar = '*'
      ShowHint = True
      TabOrder = 1
      TextHint = 'Input Password'
    end
    object Button_login_baru: TButton
      Left = 48
      Top = 128
      Width = 65
      Height = 41
      Caption = 'LOGIN'
      TabOrder = 2
      OnClick = Button_login_baruClick
    end
    object Button_cencel_baru: TButton
      Left = 142
      Top = 128
      Width = 59
      Height = 41
      Caption = 'CENCEL'
      TabOrder = 3
      OnClick = Button_cencel_baruClick
    end
    object Edit1: TEdit
      Left = 200
      Top = 284
      Width = 121
      Height = 21
      TabOrder = 4
      Text = 'Edit1'
    end
  end
end
