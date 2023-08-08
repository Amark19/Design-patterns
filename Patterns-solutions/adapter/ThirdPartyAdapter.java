package net.media.training.designpattern.adapter;

import net.media.training.designpattern.adapter.thirdparty.ThirdPartyLeaveRecord;

public class ThirdPartyAdapter implements LeaveRecord {
    private ThirdPartyLeaveRecord thirdPartyLeaveRecorder;
    // private Employee employee;

    public ThirdPartyAdapter(ThirdPartyLeaveRecord thirdPartyLeaveRecorder) {
        this.thirdPartyLeaveRecorder = thirdPartyLeaveRecorder;
    }

    @Override
    public String getMostAbsentEmployee() {
        return thirdPartyLeaveRecorder.getMostAbsentEmployee().getName();
    }

    @Override
    public int getEmployeeAbsences(String employeeName) {
        Employee employee = new Employee(employeeName);
        return thirdPartyLeaveRecorder.getEmployeeAbsences(employee);
    }
}
