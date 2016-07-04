using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Runtime.InteropServices;
using System.Diagnostics;

namespace CtrlQ
{
    public partial class Form1 : Form
    {
        // Hotkey
        // http://www.codeproject.com/Articles/5914/Simple-steps-to-enable-Hotkey-and-ShortcutInput-us
        [DllImport("user32.dll")]
        public static extern bool RegisterHotKey(IntPtr hWnd, int id, int fsModifiers, int vlc);
        [DllImport("user32.dll")]
        public static extern bool UnregisterHotKey(IntPtr hWnd, int id);

        // Focus -> program
        // http://stackoverflow.com/questions/2315561/correct-way-in-net-to-switch-the-focus-to-another-application
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        [return: System.Runtime.InteropServices.MarshalAs(System.Runtime.InteropServices.UnmanagedType.Bool)]
        static extern bool ShowWindow(IntPtr hWnd, ShowWindowEnum flags);
        private enum ShowWindowEnum
        {
            Hide = 0,
            ShowNormal = 1, ShowMinimized = 2, ShowMaximized = 3,
            Maximize = 3, ShowNormalNoActivate = 4, Show = 5,
            Minimize = 6, ShowMinNoActivate = 7, ShowNoActivate = 8,
            Restore = 9, ShowDefault = 10, ForceMinimized = 11
        };
        [System.Runtime.InteropServices.DllImport("user32.dll")]
        public static extern int SetForegroundWindow(IntPtr hwnd);

        // Unminimize
        // http://stackoverflow.com/questions/9099479/restore-a-minimized-window-of-another-application
        private const int SW_SHOWNORMAL = 1;
        private const int SW_SHOWMAXIMIZED = 3;
        private const int SW_RESTORE = 9;

        [DllImport("user32.dll")]
        private static extern bool ShowWindow(IntPtr hWnd, int nCmdShow);

        // This is called when the hotkey is pressed.
        protected override void WndProc(ref Message m)
        {
            if (m.Msg == 0x0312)
            {
                // Hotkey pressed
                BringWindowToFront("Mathematica");

                // Contact LUI and ask it to give focus to the LUI notebook
                // and put the keyboard focus into the input field.
                string response = new System.Net.WebClient().DownloadString("http://127.0.0.1:7899/hotkey");
            }
            base.WndProc(ref m);
        }

        // Give focus to application
        public void BringWindowToFront(string processName)
        {
            // Get process
            Process process = Process.GetProcessesByName(processName).FirstOrDefault();

            IntPtr hWnd = IntPtr.Zero;

            if (process == null || process.MainWindowHandle == IntPtr.Zero)
            {
                foreach (Process thisProcess in Process.GetProcesses())
                {
                    if (thisProcess.MainWindowTitle.Contains(processName))
                    {
                        hWnd = thisProcess.MainWindowHandle;
                        break;
                    }
                }
            }
            else
            {
                hWnd = process.MainWindowHandle;
            }

            if (hWnd != IntPtr.Zero)
            {
                // Unminimize
                ShowWindow(hWnd, SW_RESTORE);

                // Set focus
                SetForegroundWindow(hWnd);
            }
            else
            {
                Console.Beep();
            }
        }

        private NotifyIcon trayIcon;
        private ContextMenu trayMenu;

        public Form1()
        {
            //InitializeComponent();

            trayMenu = new ContextMenu();
            trayMenu.MenuItems.Add("Exit", OnExit);

            trayIcon = new NotifyIcon();
            trayIcon.Text = "Ctrl-Q";
            trayIcon.Icon = new Icon(SystemIcons.Application, 40, 40);

            trayIcon.ContextMenu = trayMenu;
            trayIcon.Visible = true;
        }

        private void OnExit(object sender, EventArgs e)
        {
            Application.Exit();
        }

        protected override void OnLoad(EventArgs e)
        {
            Visible = false;
            ShowInTaskbar = false;

            // Ctrl-Q
            // Alt = 1, Ctrl = 2, Shift = 4, Win = 8
            RegisterHotKey(this.Handle, this.GetType().GetHashCode(), 2, (int)'Q');

            base.OnLoad(e);
        }
    }
}
