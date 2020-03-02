
            function calculateAmount(policy,val,amount) {
                var tot_price
                var message
                var total_amount
            if(policy==""||val==""||amount=="")
            {
            alert("Please...You need to fill all fields.Thanks...");
            }
            else if(amount < 1000000 || amount > 50000000){
                alert("Your Sum Insured amount must be between 1000000 kyats and 50000000 kyats.");
                }
            else{
                if(policy == 5){
                    if(val == 1){
                     tot_price = amount * 0.190800;}
                    else if(val >= 2 && val <= 4){
                        tot_price = amount * 0.192000;
                    }
                    else if(val == 5 || val == 6){
                        tot_price = amount * 0.193200;
                    }else if(val == 7 || val == 8){
                        tot_price = amount * 0.194400;
                    }else if(val >= 9 && val <= 11){
                        tot_price = amount * 0.195600;
                    }else if(val == 12 || val == 13){
                        tot_price = amount * 0.196800;
                    }else if(val == 14 || val == 15){
                        tot_price = amount * 0.198000;
                    }else if(val == 16){
                        tot_price = amount * 0.199200;
                    }else if(val == 17){
                        tot_price = amount * 0.200400;
                    }else if(val == 18){
                        tot_price = amount * 0.201600;
                    }else if(val == 19){
                        tot_price = amount * 0.202800;
                    }else if(val == 20){
                        tot_price = amount * 0.204000;
                    }else if(val == 21){
                        tot_price = amount * 0.205200;
                    }
                }

                if(policy == 7){
                    if(val == 1 || val == 2){
                     tot_price = amount * 0.130800;}
                    else if(val >= 3 && val <= 5){
                        tot_price = amount * 0.132000;
                    }else if(val == 6){
                        tot_price = amount * 0.133200;
                    }else if(val == 7 || val == 8){
                        tot_price = amount * 0.134400;
                    }else if(val == 9 || val == 10){
                        tot_price = amount * 0.135600;
                    }else if(val == 11 || val == 12){
                        tot_price = amount * 0.136800;
                    }else if(val == 13 || val == 14){
                        tot_price = amount * 0.138000;
                    }else if(val == 15){
                        tot_price = amount * 0.139200;
                    }else if(val == 16){
                        tot_price = amount * 0.140400;
                    }else if(val == 17 || val == 18){
                        tot_price = amount * 0.141600;
                    }else if(val == 19){
                        tot_price = amount * 0.144000;
                    }else {
                        alert("Sorry!!...Do not allow short term insurance at this age for 7-years.");
                    }
                }
                if(policy == 10){
                    if(val >= 1 && val <= 3){
                     tot_price = amount * 0.086400;}
                    else if(val == 4 || val == 5){
                        tot_price = amount * 0.087600;
                    }else if(val == 6){
                        tot_price = amount * 0.088800;
                    }else if(val == 7){
                        tot_price = amount * 0.090000;
                    }else if(val == 8 || val == 9){
                        tot_price = amount * 0.091200;
                    }else if(val == 10 || val == 11){
                        tot_price = amount * 0.092400;
                    }else if(val == 12 || val == 13){
                        tot_price = amount * 0.093600;
                    }else if(val == 14){
                        tot_price = amount * 0.094800;
                    }else if(val == 15){
                        tot_price = amount * 0.096000;
                    }else if(val == 16){
                        tot_price = amount * 0.097200;
                    }else {
                        alert("Sorry!!...Do not allow short term insurance at this age for 10-years.");
                    }
                }
            }
                 
                /*display the result*/
                var month = document.getElementById('mon_amount');
                month.value = tot_price/12;
                var  quar= document.getElementById('qua_amount');
                quar.value = tot_price/4;
                var half = document.getElementById('half_amount');
                half.value = tot_price/2;
                var divobj = document.getElementById('tot_amount');
                divobj.value = tot_price;
                var total = document.getElementById('total_amount');
                total.value = tot_price*policy;
                var benefit = document.getElementById('benefit_amount');
                benefit.value = amount - total.value;
            }
            