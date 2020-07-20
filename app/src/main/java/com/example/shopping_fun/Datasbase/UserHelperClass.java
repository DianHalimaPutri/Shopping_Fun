package com.example.shopping_fun.Datasbase;

        public class UserHelperClass {

            String fullname , email , username , password , date , gender, phoenNo;

            public UserHelperClass(){}

            public UserHelperClass(String fullname, String email, String username, String password, String date, String gender, String phoenNo) {
                this.fullname = fullname;
                this.email = email;
                this.username = username;
                this.password = password;
                this.date = date;
                this.gender = gender;
                this.phoenNo = phoenNo;
            }

            public String getFullname() {
                return fullname;
            }

            public void setFullname(String fullname) {
                this.fullname = fullname;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getPhoenNo() {
                return phoenNo;
            }

            public void setPhoenNo(String phoenNo) {
                this.phoenNo = phoenNo;
            }
        }
