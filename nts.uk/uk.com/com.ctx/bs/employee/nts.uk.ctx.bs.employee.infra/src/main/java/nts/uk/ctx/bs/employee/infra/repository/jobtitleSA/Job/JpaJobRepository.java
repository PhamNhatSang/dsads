package nts.uk.ctx.bs.employee.infra.repository.jobtitleSA.Job;

import java.util.Optional;

import nts.arc.layer.infra.data.JpaRepository;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.Job;
import nts.uk.ctx.bs.employee.dom.jobtitleSA.job.JobRepository;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job.JobTable;
import nts.uk.ctx.bs.employee.infra.entity.jobtitleSA.Job.JobTablePK;

public class JpaJobRepository extends JpaRepository implements JobRepository{
    private JobTable toEntity(Job job){
    	    JobTable entity= this.queryProxy()
    	    		.find(new JobTablePK(job.getJobInforId()),  JobTable.class)
    	    		.orElse(new JobTable());
    	    entity.setJobId(new JobTablePK(job.getJobInforId()));
    	    entity.setJobCode(job.getJobCode());
    	    entity.setIsAbolition(new Boolean(job.isAbolition()));
    	    return entity;
    }
	@Override
	public void addJob(Job job) {
		this.commandProxy().insert(this.toEntity(job));
		
	}

	@Override
	public void updateJob(Job job) {
		this.commandProxy().update(this.toEntity(job));
		
	}

	@Override
	public Optional<Job> findByJobInforId(String jobInforId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Job> findByHistoryId(String historyId) {
		// TODO Auto-generated method stub
		return null;
	}

}